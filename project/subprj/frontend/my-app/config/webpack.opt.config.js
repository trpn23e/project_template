const webpack = require('webpack');
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
const CompressionPlugin = require("compression-webpack-plugin");

// webpack 4 optimization
// webpack.dev, prod config에 merge되서 사용됨 (독립적으로 사용못함)

module.exports = {
  optimization: {
    splitChunks: {
      chunks: 'initial',
      // chunks: 'all',
      // 사이즈로 끊어서 chunk를 만들어낸다. 호출은 결국 bundle js의 chunk들의 모음임
      minSize: 200000, 
      maxSize: 244000,
      maxAsyncRequests: 5,
      maxInitialRequests: 3,
      name: true,
      cacheGroups: {
        default: {
          enforce: true,
          priority: 1
        },
        vendors: {
          test: /[\\/]node_modules[\\/]/,
          priority: 2,
          name: 'vendors',
          enforce: true,
          chunks: 'async'
        }
      }
    },
    minimizer: [
      new UglifyJsPlugin({
        cache: true,
        parallel: false,
        uglifyOptions: {
          compress: true,
          ecma: 6,
          mangle: true,
          drop_console: true,
          conditionals: true,
          unused: true,
          comparisons: true,
          dead_code: true,
          if_return: true,
          join_vars: true,
          // warnings: false
          warning: "verbose"
        },
        sourceMap: true
      }),
      new CompressionPlugin({
        asset: "[path].gz[query]",
        algorithm: "gzip",
        test: /\.js$|\.css$|\.html$/,
        threshold: 10240,
        minRatio: 0.8
      })
    ]
  }
}