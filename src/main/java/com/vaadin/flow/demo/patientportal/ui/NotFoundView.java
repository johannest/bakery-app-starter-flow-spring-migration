package com.vaadin.flow.demo.patientportal.ui;

import com.vaadin.annotations.HtmlImport;
import com.vaadin.annotations.Tag;
import com.vaadin.flow.demo.patientportal.ui.utils.BakeryConst;
import com.vaadin.flow.router.View;
import com.vaadin.flow.template.PolymerTemplate;
import com.vaadin.flow.template.model.TemplateModel;
import com.vaadin.hummingbird.ext.spring.annotations.ParentView;
import com.vaadin.hummingbird.ext.spring.annotations.Route;

@Tag("bakery-404")
@HtmlImport("frontend://src/404/bakery-404.html")
@Route(value = BakeryConst.PAGE_NOTFOUND)
@ParentView(BakeryApp.class)
public class NotFoundView extends PolymerTemplate<TemplateModel> implements View {

}
