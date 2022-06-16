Liferay.Loader.define("@liferay/frontend-js-components-sample-web@1.0.0/js/SampleWalkthrough", ['module', 'exports', 'require', 'frontend-js-components-web', 'liferay!frontend-js-react-web$react'], function (module, exports, require) {
  var define = undefined;
  var global = window;
  {
    Object.defineProperty(exports, "__esModule", {
      value: true
    });
    exports.default = SampleWalkthrough;

    var _frontendJsComponentsWeb = require("frontend-js-components-web");

    var _react = _interopRequireDefault(require("liferay!frontend-js-react-web$react"));

    function _interopRequireDefault(obj) {
      return obj && obj.__esModule ? obj : { default: obj };
    }

    function _extends() {
      _extends = Object.assign || function (target) {
        for (var i = 1; i < arguments.length; i++) {
          var source = arguments[i];for (var key in source) {
            if (Object.prototype.hasOwnProperty.call(source, key)) {
              target[key] = source[key];
            }
          }
        }return target;
      };return _extends.apply(this, arguments);
    }

    const WALKTHROUGH_CONFIG = {
      closeOnClickOutside: false,
      closeable: true,
      skippable: true,
      steps: [{
        content: '<span>Content 1</span><br/><code>Hello1</code>',
        darkbg: true,
        nodeToHighlight: '#step1',
        title: 'Title 1'
      }, {
        content: '<span>Content 2</span><br/><code>Hello2</code>',
        darkbg: true,
        nodeToHighlight: '#step2',
        positioning: 'top',
        title: 'Title 2'
      }, {
        content: '<span>Content 3</span><br/><code>Hello3</code>',
        darkbg: true,
        nodeToHighlight: '#step3',
        title: 'Title 3'
      }, {
        content: '<span>Content 4</span><br/><code>Hello4</code>',
        nodeToHighlight: '#step4',
        title: 'Title 4'
      }, {
        content: '<span>Content 5</span><br/><code>Hello5</code>',
        nodeToHighlight: '#step5',
        positioning: 'bottom',
        title: 'Title 5'
      }, {
        content: '<span>Content 6</span><br/><code>Hello6</code>',
        nodeToHighlight: '#step6',
        positioning: 'bottom',
        title: 'Title 6'
      }]
    };

    function SampleWalkthrough(...props) {
      return (/*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.Walkthrough, _extends({}, WALKTHROUGH_CONFIG, props))
      );
    }
    //# sourceMappingURL=SampleWalkthrough.js.map
  }
});
//# sourceMappingURL=SampleWalkthrough.js.map