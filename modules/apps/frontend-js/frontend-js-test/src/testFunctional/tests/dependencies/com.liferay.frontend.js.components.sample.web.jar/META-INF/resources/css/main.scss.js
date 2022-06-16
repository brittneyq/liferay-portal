(function () {
  var link = document.createElement("link");
  link.setAttribute("rel", "stylesheet");
  link.setAttribute("type", "text/css");
  link.setAttribute("href", Liferay.ThemeDisplay.getPathContext() + "/o/frontend-js-components-sample-web/css/main.css");

  function defineModule() {
    Liferay.Loader.define("@liferay/frontend-js-components-sample-web@1.0.0/css/main.scss", ['module', 'exports', 'require'], function (module, exports, require) {
      var define = undefined;
      var global = window;
      {
        module.exports = link;
      }
    });
  }

  link.onload = defineModule;

  link.onerror = function () {
    console.warn('Unable to load /o/frontend-js-components-sample-web/css/main.css. However, its .js module will still be defined to avoid breaking execution flow (expect some visual degradation).');
    defineModule();
  };

  document.querySelector("head").appendChild(link);
})();
//# sourceMappingURL=main.scss.js.map