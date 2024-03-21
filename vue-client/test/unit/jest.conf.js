const path = require('path')

module.exports = {
  verbose: true,
  testURL: "http://localhost/",
  testEnvironment: 'node',
  rootDir: path.resolve(__dirname, '../../'),
  // 测试环境，jsdom 可以在 Node 虚拟浏览器环境运行测试
  testEnvironment: 'jsdom',
  moduleFileExtensions: [
    'js',
    'json',
    'vue'
  ],
  moduleNameMapper: {
    '^@/(.*)$': '<rootDir>/src/$1'
  },
  transform: {
    '^.+\\.js$': '<rootDir>/node_modules/babel-jest',
    '.*\\.(vue)$': '<rootDir>/node_modules/vue-jest'
  },
  snapshotSerializers: ['<rootDir>/node_modules/jest-serializer-vue'],
  setupFiles: ['<rootDir>/test/unit/setup'],
  mapCoverage: true,
  // 测试覆盖率报告输出目录
  coverageDirectory: '<rootDir>/test/unit/coverage',
  // 指示应使用哪个提供程序来检测覆盖范围的代码。允许的值为 babel（默认）或 v8。
  // 请注意，使用 v8 被认为是实验性的。这使用了 V8 的内置代码覆盖率，而不是基于 Babel 的代码覆盖率。它没有经过很好的测试，并且在 Node 的最后几个版本中也得到了改进。使用最新版本的 Node（在撰写本文时为v14）会产生更好的结果。
  coverageProvider: 'babel',
  // 收集测试覆盖率
  collectCoverage: true,
  collectCoverageFrom: [
    'src/**/*.{js,vue}',
    '!src/main.js',
    '!src/router/index.js',
    '!**/node_modules/**'
  ],
  // 覆盖率阈值，如果没有达到阈值则测试失败
  coverageThreshold: {
    "global": {
      "branches": 50,
      "functions": 50,
      "lines": 50,
      "statements": 50
    },
    "./src/components/": {
      "branches": 40,
      "statements": 40
    }
  },
  // 通常，在收集代码覆盖率时会忽略测试文件。使用此选项，您可以覆盖此行为，并在代码覆盖率中包含否则被忽略的文件。
  forceCoverageMatch: ["**/*.t.js"]
}
