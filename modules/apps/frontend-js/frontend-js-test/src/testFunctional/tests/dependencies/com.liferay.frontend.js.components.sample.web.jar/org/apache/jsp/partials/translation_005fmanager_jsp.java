package org.apache.jsp.partials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.frontend.js.components.sample.web.internal.constants.FrontendJSComponentsSampleWebKeys;
import com.liferay.frontend.js.components.sample.web.internal.display.context.TranslationManagerDisplayContext;
import com.liferay.portal.kernel.util.HashMapBuilder;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class translation_005fmanager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n\n\n\n\n\n\n\n");
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.taglib.theme.DefineObjectsTag.class) : new com.liferay.taglib.theme.DefineObjectsTag();
      _jspx_th_liferay$1theme_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1theme_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1theme_defineObjects_0 = _jspx_th_liferay$1theme_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1theme_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_liferay$1theme_defineObjects_0);
        _jspx_th_liferay$1theme_defineObjects_0.release();
        return;
      }
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_liferay$1theme_defineObjects_0);
      _jspx_th_liferay$1theme_defineObjects_0.release();
      com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay = null;
      com.liferay.portal.kernel.model.Company company = null;
      com.liferay.portal.kernel.model.User user = null;
      com.liferay.portal.kernel.model.User realUser = null;
      com.liferay.portal.kernel.model.Contact contact = null;
      com.liferay.portal.kernel.model.Layout layout = null;
      java.util.List layouts = null;
      java.lang.Long plid = null;
      com.liferay.portal.kernel.model.LayoutTypePortlet layoutTypePortlet = null;
      java.lang.Long scopeGroupId = null;
      com.liferay.portal.kernel.security.permission.PermissionChecker permissionChecker = null;
      java.util.Locale locale = null;
      java.util.TimeZone timeZone = null;
      com.liferay.portal.kernel.model.Theme theme = null;
      com.liferay.portal.kernel.model.ColorScheme colorScheme = null;
      com.liferay.portal.kernel.theme.PortletDisplay portletDisplay = null;
      java.lang.Long portletGroupId = null;
      themeDisplay = (com.liferay.portal.kernel.theme.ThemeDisplay) _jspx_page_context.findAttribute("themeDisplay");
      company = (com.liferay.portal.kernel.model.Company) _jspx_page_context.findAttribute("company");
      user = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("user");
      realUser = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("realUser");
      contact = (com.liferay.portal.kernel.model.Contact) _jspx_page_context.findAttribute("contact");
      layout = (com.liferay.portal.kernel.model.Layout) _jspx_page_context.findAttribute("layout");
      layouts = (java.util.List) _jspx_page_context.findAttribute("layouts");
      plid = (java.lang.Long) _jspx_page_context.findAttribute("plid");
      layoutTypePortlet = (com.liferay.portal.kernel.model.LayoutTypePortlet) _jspx_page_context.findAttribute("layoutTypePortlet");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      permissionChecker = (com.liferay.portal.kernel.security.permission.PermissionChecker) _jspx_page_context.findAttribute("permissionChecker");
      locale = (java.util.Locale) _jspx_page_context.findAttribute("locale");
      timeZone = (java.util.TimeZone) _jspx_page_context.findAttribute("timeZone");
      theme = (com.liferay.portal.kernel.model.Theme) _jspx_page_context.findAttribute("theme");
      colorScheme = (com.liferay.portal.kernel.model.ColorScheme) _jspx_page_context.findAttribute("colorScheme");
      portletDisplay = (com.liferay.portal.kernel.theme.PortletDisplay) _jspx_page_context.findAttribute("portletDisplay");
      portletGroupId = (java.lang.Long) _jspx_page_context.findAttribute("portletGroupId");
      out.write('\n');
      out.write('\n');

TranslationManagerDisplayContext translationManagerDisplayContext = (TranslationManagerDisplayContext)request.getAttribute(FrontendJSComponentsSampleWebKeys.TRANSLATION_MANAGER_DISPLAY_CONTEXT);

      out.write('\n');
      out.write('\n');

List<String> activeLanguageIds = translationManagerDisplayContext.getActiveLanguageIds();
Set<Locale> availableLocales = translationManagerDisplayContext.getAvailableLocales();
String defaultLanguageId = translationManagerDisplayContext.getDefaultLanguageId();
Map<String, Object> translations = translationManagerDisplayContext.getTranslations();

      out.write('\n');
      out.write('\n');
      //  clay:container-fluid
      com.liferay.frontend.taglib.clay.servlet.taglib.ContainerFluidTag _jspx_th_clay_container$1fluid_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ContainerFluidTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ContainerFluidTag();
      _jspx_th_clay_container$1fluid_0.setPageContext(_jspx_page_context);
      _jspx_th_clay_container$1fluid_0.setParent(null);
      int _jspx_eval_clay_container$1fluid_0 = _jspx_th_clay_container$1fluid_0.doStartTag();
      if (_jspx_eval_clay_container$1fluid_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
        out.write('	');
        if (_jspx_meth_clay_row_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_container$1fluid_0, _jspx_page_context))
          return;
        out.write("\n\n\t");
        //  clay:row
        com.liferay.frontend.taglib.clay.servlet.taglib.RowTag _jspx_th_clay_row_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.RowTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.RowTag();
        _jspx_th_clay_row_1.setPageContext(_jspx_page_context);
        _jspx_th_clay_row_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
        int _jspx_eval_clay_row_1 = _jspx_th_clay_row_1.doStartTag();
        if (_jspx_eval_clay_row_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  react:component
          com.liferay.frontend.taglib.react.servlet.taglib.ComponentTag _jspx_th_react_component_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.react.servlet.taglib.ComponentTag.class) : new com.liferay.frontend.taglib.react.servlet.taglib.ComponentTag();
          _jspx_th_react_component_0.setPageContext(_jspx_page_context);
          _jspx_th_react_component_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_1);
          _jspx_th_react_component_0.setModule("js/TranslationManagerSamples");
          _jspx_th_react_component_0.setProps(
				HashMapBuilder.<String, Object>put(
					"activeLanguageIds", activeLanguageIds
				).put(
					"availableLocales", translationManagerDisplayContext.getAvailableLocalesJSONArray()
				).put(
					"defaultLanguageId", defaultLanguageId
				).put(
					"translations", translations
				).build()
			);
          int _jspx_eval_react_component_0 = _jspx_th_react_component_0.doStartTag();
          if (_jspx_th_react_component_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_react_component_0);
            _jspx_th_react_component_0.release();
            return;
          }
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_react_component_0);
          _jspx_th_react_component_0.release();
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_clay_row_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_1);
          _jspx_th_clay_row_1.release();
          return;
        }
        if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_1);
        _jspx_th_clay_row_1.release();
        out.write("\n\n\t<hr />\n\n\t");
        if (_jspx_meth_clay_row_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_container$1fluid_0, _jspx_page_context))
          return;
        out.write("\n\n\t");
        //  clay:row
        com.liferay.frontend.taglib.clay.servlet.taglib.RowTag _jspx_th_clay_row_3 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.RowTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.RowTag();
        _jspx_th_clay_row_3.setPageContext(_jspx_page_context);
        _jspx_th_clay_row_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
        int _jspx_eval_clay_row_3 = _jspx_th_clay_row_3.doStartTag();
        if (_jspx_eval_clay_row_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  clay:col
          com.liferay.frontend.taglib.clay.servlet.taglib.ColTag _jspx_th_clay_col_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ColTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ColTag();
          _jspx_th_clay_col_2.setPageContext(_jspx_page_context);
          _jspx_th_clay_col_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_3);
          int _jspx_eval_clay_col_2 = _jspx_th_clay_col_2.doStartTag();
          if (_jspx_eval_clay_col_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t<h3>Default</h3>\n\n\t\t\t<form>\n\t\t\t\t");
            //  aui:input
            com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.taglib.aui.InputTag.class) : new com.liferay.taglib.aui.InputTag();
            _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
            _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_col_2);
            _jspx_th_aui_input_0.setActiveLanguageIds( activeLanguageIds );
            _jspx_th_aui_input_0.setDynamicAttribute(null, "availableLocales",  availableLocales );
            _jspx_th_aui_input_0.setDefaultLanguageId( defaultLanguageId );
            _jspx_th_aui_input_0.setLabel("");
            _jspx_th_aui_input_0.setLocalized( true );
            _jspx_th_aui_input_0.setName("tm-aui-1");
            _jspx_th_aui_input_0.setType("text");
            int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
            if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_aui_input_0);
              _jspx_th_aui_input_0.release();
              return;
            }
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_aui_input_0);
            _jspx_th_aui_input_0.release();
            out.write("\n\t\t\t</form>\n\t\t");
          }
          if (_jspx_th_clay_col_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_2);
            _jspx_th_clay_col_2.release();
            return;
          }
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_2);
          _jspx_th_clay_col_2.release();
          out.write("\n\n\t\t");
          //  clay:col
          com.liferay.frontend.taglib.clay.servlet.taglib.ColTag _jspx_th_clay_col_3 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ColTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ColTag();
          _jspx_th_clay_col_3.setPageContext(_jspx_page_context);
          _jspx_th_clay_col_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_3);
          int _jspx_eval_clay_col_3 = _jspx_th_clay_col_3.doStartTag();
          if (_jspx_eval_clay_col_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t<h3>Admin</h3>\n\n\t\t\t<form>\n\t\t\t\t");
            //  aui:input
            com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.taglib.aui.InputTag.class) : new com.liferay.taglib.aui.InputTag();
            _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
            _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_col_3);
            _jspx_th_aui_input_1.setActiveLanguageIds( activeLanguageIds );
            _jspx_th_aui_input_1.setAdminMode( true );
            _jspx_th_aui_input_1.setDynamicAttribute(null, "availableLocales",  availableLocales );
            _jspx_th_aui_input_1.setDefaultLanguageId( defaultLanguageId );
            _jspx_th_aui_input_1.setLabel("");
            _jspx_th_aui_input_1.setLocalized( true );
            _jspx_th_aui_input_1.setName("tm-aui-2");
            _jspx_th_aui_input_1.setType("text");
            int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
            if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_aui_input_1);
              _jspx_th_aui_input_1.release();
              return;
            }
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_aui_input_1);
            _jspx_th_aui_input_1.release();
            out.write("\n\t\t\t</form>\n\t\t");
          }
          if (_jspx_th_clay_col_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_3);
            _jspx_th_clay_col_3.release();
            return;
          }
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_3);
          _jspx_th_clay_col_3.release();
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_clay_row_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_3);
          _jspx_th_clay_row_3.release();
          return;
        }
        if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_3);
        _jspx_th_clay_row_3.release();
        out.write("\n\n\t<hr />\n\n\t");
        if (_jspx_meth_clay_row_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_container$1fluid_0, _jspx_page_context))
          return;
        out.write("\n\n\t");
        //  clay:row
        com.liferay.frontend.taglib.clay.servlet.taglib.RowTag _jspx_th_clay_row_5 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.RowTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.RowTag();
        _jspx_th_clay_row_5.setPageContext(_jspx_page_context);
        _jspx_th_clay_row_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
        int _jspx_eval_clay_row_5 = _jspx_th_clay_row_5.doStartTag();
        if (_jspx_eval_clay_row_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n\t\t");
          //  clay:col
          com.liferay.frontend.taglib.clay.servlet.taglib.ColTag _jspx_th_clay_col_5 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ColTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ColTag();
          _jspx_th_clay_col_5.setPageContext(_jspx_page_context);
          _jspx_th_clay_col_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_5);
          int _jspx_eval_clay_col_5 = _jspx_th_clay_col_5.doStartTag();
          if (_jspx_eval_clay_col_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t<h3>Default</h3>\n\n\t\t\t<form>\n\t\t\t\t");
            //  liferay-ui:input-localized
            com.liferay.taglib.ui.InputLocalizedTag _jspx_th_liferay$1ui_input$1localized_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.taglib.ui.InputLocalizedTag.class) : new com.liferay.taglib.ui.InputLocalizedTag();
            _jspx_th_liferay$1ui_input$1localized_0.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_input$1localized_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_col_5);
            _jspx_th_liferay$1ui_input$1localized_0.setActiveLanguageIds( activeLanguageIds );
            _jspx_th_liferay$1ui_input$1localized_0.setAvailableLocales( availableLocales );
            _jspx_th_liferay$1ui_input$1localized_0.setDefaultLanguageId( defaultLanguageId );
            _jspx_th_liferay$1ui_input$1localized_0.setName("tm-liferay-ui-1");
            _jspx_th_liferay$1ui_input$1localized_0.setXml("");
            int _jspx_eval_liferay$1ui_input$1localized_0 = _jspx_th_liferay$1ui_input$1localized_0.doStartTag();
            if (_jspx_th_liferay$1ui_input$1localized_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_liferay$1ui_input$1localized_0);
              _jspx_th_liferay$1ui_input$1localized_0.release();
              return;
            }
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_liferay$1ui_input$1localized_0);
            _jspx_th_liferay$1ui_input$1localized_0.release();
            out.write("\n\t\t\t</form>\n\t\t");
          }
          if (_jspx_th_clay_col_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_5);
            _jspx_th_clay_col_5.release();
            return;
          }
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_5);
          _jspx_th_clay_col_5.release();
          out.write("\n\n\t\t");
          //  clay:col
          com.liferay.frontend.taglib.clay.servlet.taglib.ColTag _jspx_th_clay_col_6 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ColTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ColTag();
          _jspx_th_clay_col_6.setPageContext(_jspx_page_context);
          _jspx_th_clay_col_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_5);
          int _jspx_eval_clay_col_6 = _jspx_th_clay_col_6.doStartTag();
          if (_jspx_eval_clay_col_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n\t\t\t<h3>Admin</h3>\n\n\t\t\t<form>\n\t\t\t\t");
            //  liferay-ui:input-localized
            com.liferay.taglib.ui.InputLocalizedTag _jspx_th_liferay$1ui_input$1localized_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.taglib.ui.InputLocalizedTag.class) : new com.liferay.taglib.ui.InputLocalizedTag();
            _jspx_th_liferay$1ui_input$1localized_1.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_input$1localized_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_col_6);
            _jspx_th_liferay$1ui_input$1localized_1.setActiveLanguageIds( activeLanguageIds );
            _jspx_th_liferay$1ui_input$1localized_1.setAdminMode( true );
            _jspx_th_liferay$1ui_input$1localized_1.setAvailableLocales( availableLocales );
            _jspx_th_liferay$1ui_input$1localized_1.setDefaultLanguageId( defaultLanguageId );
            _jspx_th_liferay$1ui_input$1localized_1.setName("tm-liferay-ui-2");
            _jspx_th_liferay$1ui_input$1localized_1.setXml("");
            int _jspx_eval_liferay$1ui_input$1localized_1 = _jspx_th_liferay$1ui_input$1localized_1.doStartTag();
            if (_jspx_th_liferay$1ui_input$1localized_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_liferay$1ui_input$1localized_1);
              _jspx_th_liferay$1ui_input$1localized_1.release();
              return;
            }
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_liferay$1ui_input$1localized_1);
            _jspx_th_liferay$1ui_input$1localized_1.release();
            out.write("\n\t\t\t</form>\n\t\t");
          }
          if (_jspx_th_clay_col_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_6);
            _jspx_th_clay_col_6.release();
            return;
          }
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_6);
          _jspx_th_clay_col_6.release();
          out.write('\n');
          out.write('	');
        }
        if (_jspx_th_clay_row_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_5);
          _jspx_th_clay_row_5.release();
          return;
        }
        if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_5);
        _jspx_th_clay_row_5.release();
        out.write('\n');
      }
      if (_jspx_th_clay_container$1fluid_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_container$1fluid_0);
        _jspx_th_clay_container$1fluid_0.release();
        return;
      }
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_container$1fluid_0);
      _jspx_th_clay_container$1fluid_0.release();
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_clay_row_0(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_container$1fluid_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:row
    com.liferay.frontend.taglib.clay.servlet.taglib.RowTag _jspx_th_clay_row_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.RowTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.RowTag();
    _jspx_th_clay_row_0.setPageContext(_jspx_page_context);
    _jspx_th_clay_row_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
    int _jspx_eval_clay_row_0 = _jspx_th_clay_row_0.doStartTag();
    if (_jspx_eval_clay_row_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t");
      if (_jspx_meth_clay_col_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_0, _jspx_page_context))
        return true;
      out.write('\n');
      out.write('	');
    }
    if (_jspx_th_clay_row_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_0);
      _jspx_th_clay_row_0.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_0);
    _jspx_th_clay_row_0.release();
    return false;
  }

  private boolean _jspx_meth_clay_col_0(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:col
    com.liferay.frontend.taglib.clay.servlet.taglib.ColTag _jspx_th_clay_col_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ColTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ColTag();
    _jspx_th_clay_col_0.setPageContext(_jspx_page_context);
    _jspx_th_clay_col_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_0);
    int _jspx_eval_clay_col_0 = _jspx_th_clay_col_0.doStartTag();
    if (_jspx_eval_clay_col_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t\t<h2>React Component</h2>\n\t\t");
    }
    if (_jspx_th_clay_col_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_0);
      _jspx_th_clay_col_0.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_0);
    _jspx_th_clay_col_0.release();
    return false;
  }

  private boolean _jspx_meth_clay_row_2(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_container$1fluid_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:row
    com.liferay.frontend.taglib.clay.servlet.taglib.RowTag _jspx_th_clay_row_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.RowTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.RowTag();
    _jspx_th_clay_row_2.setPageContext(_jspx_page_context);
    _jspx_th_clay_row_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
    int _jspx_eval_clay_row_2 = _jspx_th_clay_row_2.doStartTag();
    if (_jspx_eval_clay_row_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t");
      if (_jspx_meth_clay_col_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_2, _jspx_page_context))
        return true;
      out.write('\n');
      out.write('	');
    }
    if (_jspx_th_clay_row_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_2);
      _jspx_th_clay_row_2.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_2);
    _jspx_th_clay_row_2.release();
    return false;
  }

  private boolean _jspx_meth_clay_col_1(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:col
    com.liferay.frontend.taglib.clay.servlet.taglib.ColTag _jspx_th_clay_col_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ColTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ColTag();
    _jspx_th_clay_col_1.setPageContext(_jspx_page_context);
    _jspx_th_clay_col_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_2);
    int _jspx_eval_clay_col_1 = _jspx_th_clay_col_1.doStartTag();
    if (_jspx_eval_clay_col_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t\t<h2>AUI Tag</h2>\n\t\t");
    }
    if (_jspx_th_clay_col_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_1);
      _jspx_th_clay_col_1.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_1);
    _jspx_th_clay_col_1.release();
    return false;
  }

  private boolean _jspx_meth_clay_row_4(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_container$1fluid_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:row
    com.liferay.frontend.taglib.clay.servlet.taglib.RowTag _jspx_th_clay_row_4 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.RowTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.RowTag();
    _jspx_th_clay_row_4.setPageContext(_jspx_page_context);
    _jspx_th_clay_row_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
    int _jspx_eval_clay_row_4 = _jspx_th_clay_row_4.doStartTag();
    if (_jspx_eval_clay_row_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t");
      if (_jspx_meth_clay_col_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_4, _jspx_page_context))
        return true;
      out.write('\n');
      out.write('	');
    }
    if (_jspx_th_clay_row_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_4);
      _jspx_th_clay_row_4.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_4);
    _jspx_th_clay_row_4.release();
    return false;
  }

  private boolean _jspx_meth_clay_col_4(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:col
    com.liferay.frontend.taglib.clay.servlet.taglib.ColTag _jspx_th_clay_col_4 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ColTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ColTag();
    _jspx_th_clay_col_4.setPageContext(_jspx_page_context);
    _jspx_th_clay_col_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_4);
    int _jspx_eval_clay_col_4 = _jspx_th_clay_col_4.doStartTag();
    if (_jspx_eval_clay_col_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t\t<h2>Liferay UI Tag</h2>\n\t\t");
    }
    if (_jspx_th_clay_col_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_4);
      _jspx_th_clay_col_4.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_col_4);
    _jspx_th_clay_col_4.release();
    return false;
  }
}
