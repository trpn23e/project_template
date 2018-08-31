const webpack = require('webpack');
const merge = require('webpack-merge');
const baseConfig = require('./webpack.base.config');
const optimizationConfig = require('./webpack.opt.config');
const mode = process.env.NODE_ENV || 'development';

const prodConfiguration = {
  mode: 'production',
  devtool: '',
  module: {
    rules: [
      { 
        test: /\.html$/,
        loader: "html-loader",
        options: { minimize: true }
      }
    ]
  },
  plugins: [
    new webpack.DefinePlugin({ 'process.env.NODE_ENV': JSON.stringify(mode) })
  ]
}

// module.exports = merge.smart(baseConfig, prodConfiguration, optimizationConfig)
// module.exports = Object.assign(baseConfig, optimizationConfig, prodConfiguration)
module.exports = merge.smart(baseConfig, optimizationConfig, prodConfiguration)
