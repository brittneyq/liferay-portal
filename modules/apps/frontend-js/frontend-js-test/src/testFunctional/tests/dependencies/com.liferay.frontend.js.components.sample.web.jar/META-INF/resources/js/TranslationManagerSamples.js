Liferay.Loader.define("@liferay/frontend-js-components-sample-web@1.0.0/js/TranslationManagerSamples", ['module', 'exports', 'require', '@frontend-taglib-clay$clayui/layout', '@liferay/frontend-js-state-web', 'frontend-js-components-web', 'liferay!frontend-js-react-web$react'], function (module, exports, require) {
  var define = undefined;
  var global = window;
  {
    Object.defineProperty(exports, "__esModule", {
      value: true
    });
    exports.default = TranslationManagerSamples;

    var _layout = _interopRequireDefault(require("@frontend-taglib-clay$clayui/layout"));

    var _frontendJsStateWeb = require("@liferay/frontend-js-state-web");

    var _frontendJsComponentsWeb = require("frontend-js-components-web");

    var _react = _interopRequireWildcard(require("liferay!frontend-js-react-web$react"));

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

    function _interopRequireDefault(obj) {
      return obj && obj.__esModule ? obj : { default: obj };
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
    function TranslationManagerSamples({
      activeLanguageIds: initialActiveLanguageIds,
      availableLocales,
      defaultLanguageId,
      translations
    }) {
      const [activeLanguageIds, setActiveLanguageIds] = (0, _react.useState)(initialActiveLanguageIds);
      const [selectedLanguageId, setSelectedLanguageId] = (0, _react.useState)();
      (0, _react.useEffect)(() => {
        _frontendJsStateWeb.State.subscribe(_frontendJsComponentsWeb.activeLanguageIdsAtom, setActiveLanguageIds);

        _frontendJsStateWeb.State.subscribe(_frontendJsComponentsWeb.selectedLanguageIdAtom, setSelectedLanguageId);
      }, []);
      (0, _react.useEffect)(() => {
        _frontendJsStateWeb.State.writeAtom(_frontendJsComponentsWeb.activeLanguageIdsAtom, activeLanguageIds);
      }, [activeLanguageIds]);
      (0, _react.useEffect)(() => {
        _frontendJsStateWeb.State.writeAtom(_frontendJsComponentsWeb.selectedLanguageIdAtom, selectedLanguageId);
      }, [selectedLanguageId]);
      return (/*#__PURE__*/_react.default.createElement(_react.default.Fragment, null, /*#__PURE__*/_react.default.createElement(_layout.default.Col, null, /*#__PURE__*/_react.default.createElement("h3", null, "Default"), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.TranslationAdminSelector, {
          activeLanguageIds: activeLanguageIds,
          availableLocales: availableLocales,
          defaultLanguageId: defaultLanguageId,
          onActiveLanguageIdsChange: setActiveLanguageIds,
          onSelectedLanguageIdChange: setSelectedLanguageId,
          selectedLanguageId: selectedLanguageId,
          translations: translations
        })), /*#__PURE__*/_react.default.createElement(_layout.default.Col, null, /*#__PURE__*/_react.default.createElement("h3", null, "Admin"), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.TranslationAdminSelector, {
          activeLanguageIds: activeLanguageIds,
          adminMode: true,
          availableLocales: availableLocales,
          defaultLanguageId: defaultLanguageId,
          onActiveLanguageIdsChange: setActiveLanguageIds,
          onSelectedLanguageIdChange: setSelectedLanguageId,
          selectedLanguageId: selectedLanguageId,
          translations: translations
        })), /*#__PURE__*/_react.default.createElement(_layout.default.Col, null, /*#__PURE__*/_react.default.createElement("h3", null, "Small"), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.TranslationAdminSelector, {
          activeLanguageIds: activeLanguageIds,
          adminMode: true,
          availableLocales: availableLocales,
          defaultLanguageId: defaultLanguageId,
          onActiveLanguageIdsChange: setActiveLanguageIds,
          onSelectedLanguageIdChange: setSelectedLanguageId,
          selectedLanguageId: selectedLanguageId,
          small: true,
          translations: translations
        })), /*#__PURE__*/_react.default.createElement(_layout.default.Col, null, /*#__PURE__*/_react.default.createElement("h3", null, "Only Flags"), /*#__PURE__*/_react.default.createElement(_frontendJsComponentsWeb.TranslationAdminSelector, {
          activeLanguageIds: activeLanguageIds,
          adminMode: true,
          availableLocales: availableLocales,
          defaultLanguageId: defaultLanguageId,
          onActiveLanguageIdsChange: setActiveLanguageIds,
          onSelectedLanguageIdChange: setSelectedLanguageId,
          selectedLanguageId: selectedLanguageId,
          showOnlyFlags: true,
          translations: translations
        })))
      );
    }
    //# sourceMappingURL=TranslationManagerSamples.js.map
  }
});
//# sourceMappingURL=TranslationManagerSamples.js.map