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

public final class walkable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      if (_jspx_meth_clay_container$1fluid_0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_clay_container$1fluid_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:container-fluid
    com.liferay.frontend.taglib.clay.servlet.taglib.ContainerFluidTag _jspx_th_clay_container$1fluid_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ContainerFluidTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ContainerFluidTag();
    _jspx_th_clay_container$1fluid_0.setPageContext(_jspx_page_context);
    _jspx_th_clay_container$1fluid_0.setParent(null);
    int _jspx_eval_clay_container$1fluid_0 = _jspx_th_clay_container$1fluid_0.doStartTag();
    if (_jspx_eval_clay_container$1fluid_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write('\n');
      out.write('	');
      if (_jspx_meth_clay_row_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_container$1fluid_0, _jspx_page_context))
        return true;
      out.write("\n\n\t");
      if (_jspx_meth_clay_row_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_container$1fluid_0, _jspx_page_context))
        return true;
      out.write("\n\n\t<div>\n\t\t");
      if (_jspx_meth_react_component_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_container$1fluid_0, _jspx_page_context))
        return true;
      out.write("\n\t</div>\n");
    }
    if (_jspx_th_clay_container$1fluid_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_container$1fluid_0);
      _jspx_th_clay_container$1fluid_0.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_container$1fluid_0);
    _jspx_th_clay_container$1fluid_0.release();
    return false;
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
      out.write("\n\t\t<h2>Walkable Sample</h2>\n\n\t\t<div class=\"btn-group\">\n\t\t\t<div class=\"btn-group-item\">\n\t\t\t\t");
      if (_jspx_meth_clay_button_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_0, _jspx_page_context))
        return true;
      out.write("\n\t\t\t</div>\n\n\t\t\t<div class=\"btn-group-item\">\n\t\t\t\t");
      if (_jspx_meth_clay_button_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_0, _jspx_page_context))
        return true;
      out.write("\n\t\t\t</div>\n\n\t\t\t<div class=\"btn-group-item\">\n\t\t\t\t");
      if (_jspx_meth_clay_button_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_0, _jspx_page_context))
        return true;
      out.write("\n\t\t\t</div>\n\t\t</div>\n\t");
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

  private boolean _jspx_meth_clay_button_0(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:button
    com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag _jspx_th_clay_button_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag();
    _jspx_th_clay_button_0.setPageContext(_jspx_page_context);
    _jspx_th_clay_button_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_0);
    _jspx_th_clay_button_0.setDisplayType("primary");
    _jspx_th_clay_button_0.setId("step1");
    _jspx_th_clay_button_0.setLabel("Step 1");
    int _jspx_eval_clay_button_0 = _jspx_th_clay_button_0.doStartTag();
    if (_jspx_th_clay_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_button_0);
      _jspx_th_clay_button_0.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_button_0);
    _jspx_th_clay_button_0.release();
    return false;
  }

  private boolean _jspx_meth_clay_button_1(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:button
    com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag _jspx_th_clay_button_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag();
    _jspx_th_clay_button_1.setPageContext(_jspx_page_context);
    _jspx_th_clay_button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_0);
    _jspx_th_clay_button_1.setDisplayType("primary");
    _jspx_th_clay_button_1.setId("step2");
    _jspx_th_clay_button_1.setLabel("Step 2");
    int _jspx_eval_clay_button_1 = _jspx_th_clay_button_1.doStartTag();
    if (_jspx_th_clay_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_button_1);
      _jspx_th_clay_button_1.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_button_1);
    _jspx_th_clay_button_1.release();
    return false;
  }

  private boolean _jspx_meth_clay_button_2(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:button
    com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag _jspx_th_clay_button_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.ButtonTag();
    _jspx_th_clay_button_2.setPageContext(_jspx_page_context);
    _jspx_th_clay_button_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_0);
    _jspx_th_clay_button_2.setDisplayType("primary");
    _jspx_th_clay_button_2.setId("step3");
    _jspx_th_clay_button_2.setLabel("Step 3");
    int _jspx_eval_clay_button_2 = _jspx_th_clay_button_2.doStartTag();
    if (_jspx_th_clay_button_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_button_2);
      _jspx_th_clay_button_2.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_button_2);
    _jspx_th_clay_button_2.release();
    return false;
  }

  private boolean _jspx_meth_clay_row_1(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_container$1fluid_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:row
    com.liferay.frontend.taglib.clay.servlet.taglib.RowTag _jspx_th_clay_row_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.RowTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.RowTag();
    _jspx_th_clay_row_1.setPageContext(_jspx_page_context);
    _jspx_th_clay_row_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
    int _jspx_eval_clay_row_1 = _jspx_th_clay_row_1.doStartTag();
    if (_jspx_eval_clay_row_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\n\t\t");
      if (_jspx_meth_clay_alert_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_1, _jspx_page_context))
        return true;
      out.write("\n\n\t\t");
      if (_jspx_meth_clay_alert_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_clay_row_1, _jspx_page_context))
        return true;
      out.write('\n');
      out.write('	');
    }
    if (_jspx_th_clay_row_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_1);
      _jspx_th_clay_row_1.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_row_1);
    _jspx_th_clay_row_1.release();
    return false;
  }

  private boolean _jspx_meth_clay_alert_0(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:alert
    com.liferay.frontend.taglib.clay.servlet.taglib.AlertTag _jspx_th_clay_alert_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.AlertTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.AlertTag();
    _jspx_th_clay_alert_0.setPageContext(_jspx_page_context);
    _jspx_th_clay_alert_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_1);
    _jspx_th_clay_alert_0.setDisplayType("info");
    _jspx_th_clay_alert_0.setId("step4");
    _jspx_th_clay_alert_0.setMessage("Whassup?");
    _jspx_th_clay_alert_0.setTitle("Info");
    int _jspx_eval_clay_alert_0 = _jspx_th_clay_alert_0.doStartTag();
    if (_jspx_th_clay_alert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_alert_0);
      _jspx_th_clay_alert_0.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_alert_0);
    _jspx_th_clay_alert_0.release();
    return false;
  }

  private boolean _jspx_meth_clay_alert_1(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_row_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  clay:alert
    com.liferay.frontend.taglib.clay.servlet.taglib.AlertTag _jspx_th_clay_alert_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.clay.servlet.taglib.AlertTag.class) : new com.liferay.frontend.taglib.clay.servlet.taglib.AlertTag();
    _jspx_th_clay_alert_1.setPageContext(_jspx_page_context);
    _jspx_th_clay_alert_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_row_1);
    _jspx_th_clay_alert_1.setDisplayType("info");
    _jspx_th_clay_alert_1.setId("step5");
    _jspx_th_clay_alert_1.setMessage("Whassup 2?");
    _jspx_th_clay_alert_1.setTitle("Info 2");
    int _jspx_eval_clay_alert_1 = _jspx_th_clay_alert_1.doStartTag();
    if (_jspx_th_clay_alert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_alert_1);
      _jspx_th_clay_alert_1.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_clay_alert_1);
    _jspx_th_clay_alert_1.release();
    return false;
  }

  private boolean _jspx_meth_react_component_0(javax.servlet.jsp.tagext.JspTag _jspx_th_clay_container$1fluid_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  react:component
    com.liferay.frontend.taglib.react.servlet.taglib.ComponentTag _jspx_th_react_component_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.liferay.frontend.taglib.react.servlet.taglib.ComponentTag.class) : new com.liferay.frontend.taglib.react.servlet.taglib.ComponentTag();
    _jspx_th_react_component_0.setPageContext(_jspx_page_context);
    _jspx_th_react_component_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_clay_container$1fluid_0);
    _jspx_th_react_component_0.setModule("js/SampleWalkthrough");
    int _jspx_eval_react_component_0 = _jspx_th_react_component_0.doStartTag();
    if (_jspx_th_react_component_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_react_component_0);
      _jspx_th_react_component_0.release();
      return true;
    }
    if (_jspx_resourceInjector != null) _jspx_resourceInjector.preDestroy(_jspx_th_react_component_0);
    _jspx_th_react_component_0.release();
    return false;
  }
}
