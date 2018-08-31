const webpack = require('webpack');
const merge = require('webpack-merge');
const baseConfig = require('./webpack.base.config');
const mode = process.env.NODE_ENV || 'development';

const devConfiguration = {
  mode: 'development',
  devtool: (mode === 'development') ? 'inline-source-map' : 'source-map',
  module: {
    rules: [
      { 
        test: /\.html$/,
        loader: "html-loader",
        options: { minimize: false }
      }
    ]
  },
  plugins: [
    new webpack.DefinePlugin({ 'process.env.NODE_ENV': JSON.stringify(mode) })
  ],
  devServer: {
    host : '127.0.0.1',
    compress: false,
    hot : true,
    inline: true,
    port: 3000,
    open : true
  }
}

module.exports = merge.smart(baseConfig, devConfiguration)