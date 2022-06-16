Liferay.Loader.define("@liferay/frontend-js-components-sample-web@1.0.0/js/ManagementToolbarSamples", ['module', 'exports', 'require', '@frontend-taglib-clay$clayui/button', '@frontend-taglib-clay$clayui/drop-down', '@frontend-taglib-clay$clayui/form', '@frontend-taglib-clay$clayui/icon', '@frontend-taglib-clay$clayui/label', 'frontend-js-components-web', 'liferay!frontend-js-react-web$react'], function (module, exports, require) {
  var define = undefined;
  var global = window;
  {
    Object.defineProperty(exports, "__esModule", {
      value: true
    });
    exports.default = ManagementToolbarSamples;

    var _button = _interopRequireWildcard(require("@frontend-taglib-clay$clayui/button"));

    var _dropDown = require("@frontend-taglib-clay$clayui/drop-down");

    var _form = require("@frontend-taglib-clay$clayui/form");

    var _icon = _interopRequireDefault(require("@frontend-taglib-clay$clayui/icon"));

    var _label = _interopRequireDefault(require("@frontend-taglib-clay$clayui/label"));

    var _frontendJsComponentsWeb = require("frontend-js-components-web");

    var _react = _interopRequireWildcard(require("liferay!frontend-js-react-web$react"));

    function _interopRequireDefault(obj) {
      return obj && obj.__esModule ? obj : { default: obj };
    }

    function _getRequireWildcardCache() {
      if (typeof WeakMap !== "function") return null;var cache = new WeakMap();_getRequireWildcardCache = function _getRequireWildcardCache() {
        return cache;
      };return cache;
    }

    function _interopRequireWildcard(obj) {
      if (obj && obj.__esModule) {
        return obj;
      }if (obj === null || typeof obj !== "object" && typeof obj !== "function") {
        return { default: obj };
      }var cache = _getRequireWildcardCache();if (cache && cache.has(obj)) {
        return cache.get(obj);
      }var newObj = {};var hasPropertyDescriptor = Object.defineProperty && Object.getOwnPropertyDescriptor;for (var key in obj) {
        if (Object.prototype.hasOwnProperty.call(obj, key)) {
          var desc = hasPropertyDescriptor ? Object.getOwnPropertyDescriptor(obj, key) : null;if (desc && (desc.get || desc.set)) {
            Object.defineProperty(newObj, key, desc);
          } else {
            newObj[key] = obj[key];
          }
        }
      }newObj.default = obj;if (cache) {
        cache.set(obj, newObj);
      }return newObj;
    }

    /**
     * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
     *
     * This library is free software; you can redistribute it and/or modify it under
     * the terms of the GNU Lesser General Public License as published by the Free
     * Software Foundation; either version 2.1 of the License, or (at your option)
     * any later version.
     *
     * This library is distributed in the hope that it will be useful, but WITHOUT
     * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
     * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
     * details.
     */
    const filterItems = [{
      label: 'Filter Action 1',
      onClick: () => alert('Filter clicked')
    }, {
      label: 'Filter Action 2',
      onClick: () => alert('Filter clicked')
    }];
    const viewTypes = [{
      label: 'List',
      onClick: () => alert('Show view list'),
      symbolLeft: 'list'
    }, {
      active: true,
      label: 'Table',
      onClick: () => alert('Show view talbe'),
      symbolLeft: 'table'
    }, {
      label: 'Card',
      onClick: () => alert('Show view card'),
      symbolLeft: 'cards2'
    }];

    function ManagementToolbarSamples() {
      const [searchMobile, setSearchMobile] = (0, _react.useState)(false);
      const viewTypeActive = viewTypes.find(type => type.active);
      return (/*#__PURE__*/_react.default.createElement(_react.default.Fragment, null, /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Container, {
          "aria-label": "Management toolbar"
        }, /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.ItemList, null, /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Item, null, /*#__PURE__*/_react.default.createElement(_form.ClayCheckbox, {
          checked: false,
          onChange: () => {}
        })), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Item, null, /*#__PURE__*/_react.default.createElement(_dropDown.ClayDropDownWithItems, {
          items: filterItems,
          trigger: /*#__PURE__*/_react.default.createElement(_button.default, {
            "aria-label": "Filter items",
            className: "nav-link",
            displayType: "link"
          }, /*#__PURE__*/_react.default.createElement("span", {
            className: "navbar-breakpoint-down-d-none"
          }, /*#__PURE__*/_react.default.createElement("span", {
            className: "navbar-text-truncate"
          }, "Filter and Order"), /*#__PURE__*/_react.default.createElement(_icon.default, {
            className: "inline-item inline-item-after",
            symbol: "caret-bottom"
          })), /*#__PURE__*/_react.default.createElement("span", {
            className: "navbar-breakpoint-d-none"
          }, /*#__PURE__*/_react.default.createElement(_icon.default, {
            symbol: "filter"
          })))
        })), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Item, null, /*#__PURE__*/_react.default.createElement(_button.default, {
          "aria-label": "Order items",
          className: "nav-link nav-link-monospaced",
          displayType: "link",
          onClick: () => {}
        }, /*#__PURE__*/_react.default.createElement(_icon.default, {
          symbol: "order-list-up"
        })))), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Search, {
          showMobile: searchMobile
        }, /*#__PURE__*/_react.default.createElement(_form.ClayInput.Group, null, /*#__PURE__*/_react.default.createElement(_form.ClayInput.GroupItem, null, /*#__PURE__*/_react.default.createElement(_form.ClayInput, {
          "aria-label": "Search",
          className: "form-control input-group-inset input-group-inset-after",
          defaultValue: "Red",
          type: "text"
        }), /*#__PURE__*/_react.default.createElement(_form.ClayInput.GroupInsetItem, {
          after: true,
          tag: "span"
        }, /*#__PURE__*/_react.default.createElement(_button.ClayButtonWithIcon, {
          "aria-label": "Clear search button",
          className: "navbar-breakpoint-d-none",
          displayType: "unstyled",
          onClick: () => setSearchMobile(false),
          symbol: "times"
        }), /*#__PURE__*/_react.default.createElement(_button.ClayButtonWithIcon, {
          "aria-label": "Search button",
          displayType: "unstyled",
          symbol: "search",
          type: "submit"
        }))))), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.ItemList, null, /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Item, {
          className: "navbar-breakpoint-d-none"
        }, /*#__PURE__*/_react.default.createElement(_button.default, {
          "aria-label": "Search button mobile",
          className: "nav-link nav-link-monospaced",
          displayType: "unstyled",
          onClick: () => setSearchMobile(true)
        }, /*#__PURE__*/_react.default.createElement(_icon.default, {
          symbol: "search"
        }))), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Item, null, /*#__PURE__*/_react.default.createElement(_button.default, {
          "aria-label": "Information",
          className: "nav-link nav-link-monospaced",
          displayType: "link",
          onClick: () => {}
        }, /*#__PURE__*/_react.default.createElement(_icon.default, {
          symbol: "info-circle-open"
        }))), /*#__PURE__*/_react.default.createElement(_dropDown.ClayDropDownWithItems, {
          containerElement: _frontendJsComponentsWeb.ManagementToolbar.Item,
          items: viewTypes,
          trigger: /*#__PURE__*/_react.default.createElement(_button.default, {
            "aria-label": "Display type",
            className: "nav-link nav-link-monospaced",
            displayType: "link"
          }, /*#__PURE__*/_react.default.createElement(_icon.default, {
            symbol: viewTypeActive ? viewTypeActive.symbolLeft : ''
          }))
        }), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.Item, null, /*#__PURE__*/_react.default.createElement(_button.ClayButtonWithIcon, {
          "aria-label": "Add new",
          className: "nav-btn nav-btn-monospaced",
          symbol: "plus"
        })))), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.ResultsBar, null, /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.ResultsBarItem, null, /*#__PURE__*/_react.default.createElement("span", {
          className: "component-text text-truncate-inline"
        }, /*#__PURE__*/_react.default.createElement("span", {
          className: "text-truncate"
        }, "2 results for ", /*#__PURE__*/_react.default.createElement("strong", null, "Red")))), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.ResultsBarItem, {
          expand: true
        }, /*#__PURE__*/_react.default.createElement(_label.default, {
          className: "component-label tbar-label",
          displayType: "unstyled"
        }, "Filter")), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.ManagementToolbar.ResultsBarItem, null, /*#__PURE__*/_react.default.createElement(_button.default, {
          className: "component-link tbar-link",
          displayType: "link"
        }, "Clear"))))
      );
    }
    //# sourceMappingURL=ManagementToolbarSamples.js.map
  }
});
//# sourceMappingURL=ManagementToolbarSamples.js.map