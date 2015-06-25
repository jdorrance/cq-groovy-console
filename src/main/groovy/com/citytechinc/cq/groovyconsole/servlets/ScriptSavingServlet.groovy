package com.citytechinc.cq.groovyconsole.servlets

import com.citytechinc.cq.groovyconsole.services.GroovyConsoleService
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.felix.scr.annotations.Reference
import org.apache.felix.scr.annotations.sling.SlingServlet
import org.apache.sling.api.SlingHttpServletRequest
import org.apache.sling.api.SlingHttpServletResponse
import org.apache.sling.api.servlets.SlingAllMethodsServlet

import javax.servlet.ServletException

@SlingServlet(paths = "/bin/groovyconsole/save")
class ScriptSavingServlet extends SlingAllMethodsServlet {

    @Reference
    GroovyConsoleService consoleService

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws
        ServletException, IOException {
        def result = consoleService.saveScript(request)

        response.contentType = "application/json"
        def mapper = new ObjectMapper()
        mapper.writeValue(response.writer,result)
    }
}