const path = require('path');
const webpack = require('webpack');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
// const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const ExtractTextPlugin = require('extract-text-webpack-plugin');
// const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
// const CompressionPlugin = require("compression-webpack-plugin");
const ManifestPlugin = require('webpack-manifest-plugin');

function resolve (dir) {
  return path.join(__dirname, '..', dir)
}

module.exports = {
  // entry: resolve('src/index.js'),
  entry: ["babel-polyfill", resolve('src/index.js')],
  // path: path.resolve(__dirname, 'build'),
	output: {
    // filename: 'bundle.js',
    filename: 'bundle.[hash].js',
    path: resolve('build'),
    // 이 경로는 webpack기준 context(?) root 디렉토리가 됨 HtmlWebpackPlugin
    // 에서 html에 bundle js 선언을 자동으로 넣어주는데에도 사용된다
    publicPath: ''
  },
  module: {
      rules: [
          {
              test: /\.(js|jsx)$/,
              loader: "babel-loader",
              exclude: /node_modules/
          },
          // { 
          //   test: /\.html$/,
          //   loader: "html-loader",
          //   options: { minimize: true }
          // },
          // {
          //   test: /\.(css|scss)$/,
          //   use: [
          //     { loader: "style-loader"},
          //     { loader: 'css-loader', options: { url: false, sourceMap: true } },
          //     { loader: 'sass-loader', options: { sourceMap: true } }
          //   ]
          // },
          {
            test: /\.(css|scss)$/,
            use: ExtractTextPlugin.extract({
              fallback: 'style-loader',
              use: [
                { loader: 'css-loader', options: { url: false, sourceMap: true } },
                { loader: 'sass-loader', options: { sourceMap: true } }
              ]
            })
          },
          {
              test : /\.(png|svg)(\?.*)?$/,
              loader: 'url-loader',
              options: {
                name: '[name].[ext]?[hash]',
                limit: 100000
              }
          },
          {
              test: /\.(ico|jpe?g|gif)(\?.*)?$/,
              // loader: 'url-loader',
              loader: 'file-loader',
              // test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
              // loader: 'url-loader',
              // exclude: [ resolve('src/icons') ],
              options: {
                name: '[name].[ext]?[hash]'
              },
              exclude: [ resolve('src/icons') ]
          },
          {
            test: /\.(mp4|webm|ogg|mp3|wav|flac|aac)(\?.*)?$/,
            loader: 'url-loader',
            options: {
              name: '[name].[ext]?[hash]',
              limit: 10000
            }
          },
          {
              // test: /\.(woff|woff2|eot|ttf|otf)$/,
              // loader: 'file-loader'
              test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
              loader: 'url-loader',
              options: {
                name: '[name].[ext]?[hash]',
                limit: 10000
              }
          },
          {
            test: /\.svg$/,
            loader: 'svg-sprite-loader',
            exclude: [ resolve('src/icons') ],
            options: {
              symbolId: 'icon-[name]'
            }
          }
      ]
    },
    plugins: [
      new CleanWebpackPlugin(['build'], { root: resolve('') }),
      new HtmlWebpackPlugin({
          favicon: resolve('public/favicon.ico'),
          template: resolve('public/index.html')
          // chunks: ['css', 'index', 'app', 'system', 'monitor']
      }),
      new ExtractTextPlugin({
        // 일반 npm start때와 run dev,build시의 css 내의 상대경로등의 위치를 동일하게 가져가기 위해
        // 동일 경로에 css를 export하도록 함 (배포는 webpack output path 기준임(build))
        filename: "resources/css/bundle.css",
        disable: false,
        allChunks: true
      }),
      new webpack.ProvidePlugin({
        $: 'jquery',
        jQuery: 'jquery',
        'window.jQuery': 'jquery'
        // Popper: 'popper.js'
      }),
      // 설정된 resource들을 build target 디렉토리에 복사해준다
      new CopyWebpackPlugin([
        // { from: './src/resources/css', to: './css', flatten: true },
        // { from: './src/resources/font/**', to: './font', flatten: true },
        // { from: './src/resources/img/**', to: './img', flatten: true }
        { from: './src/resources/css', to: 'resources/css', flatten: true },
        { from: './src/resources/font/notosanserif2', to: 'resources/font/notosanserif2', flatten: true },
        { from: './src/resources/img/**', to: 'resources/img', flatten: true }
      ]),
      new ManifestPlugin({
        fileName: 'assets.json',
        basePath: '/'
      }),
      new BundleAnalyzerPlugin({
        analyzerHost: '127.0.0.1',
        analyzerPort: 8888
      })
    ],
    // optimization: {
    //   splitChunks: {
    //     chunks: 'initial',
    //     cacheGroups: {
    //       default: {
    //         enforce: true,
    //         priority: 1
    //       },
    //       vendors: {
    //         test: /[\\/]node_modules[\\/]/,
    //         priority: 2,
    //         name: 'vendors',
    //         enforce: true,
    //         chunks: 'async'
    //       }
    //     }
    //   },
    //   minimizer: [
    //     new UglifyJsPlugin({
    //       cache: true,
    //       parallel: false,
    //       uglifyOptions: {
    //         compress: false,
    //         ecma: 6,
    //         mangle: true,
    //         drop_console: true,
    //         conditionals: true,
    //         unused: true,
    //         comparisons: true,
    //         dead_code: true,
    //         if_return: true,
    //         join_vars: true,
    //         // warnings: false
    //         warning: "verbose"
    //       },
    //       sourceMap: true
    //     }),
    //     new CompressionPlugin({
    //       asset: "[path].gz[query]",
    //       algorithm: "gzip",
    //       test: /\.js$|\.css$|\.html$/,
    //       threshold: 10240,
    //       minRatio: 0.8
    //     })
    //   ]
    // },
    devServer: {
      host : '127.0.0.1',
      // contentBase: path.join(__dirname, "build"),
      // contentBase: './build',
      contentBase: resolve('build'),
      compress: false,
      hot : true,
      inline: true,
      port: 3000,
      open : false
    }
};
