package com.koopab.draak

@Grab(group="org.mortbay.jetty", module="jetty-embedded", version="6.1.22")
import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.*
import groovy.servlet.TemplateServlet

class DraakApp {
    def routes = [:]

    def route(method, url, block = null) {
        routes[method] = routes[method] ?: []
        routes[method] << new Expando([url : url, block : block])
    }
    
    def startApp() {
        println "Starting Draak w/ the following routes:"
        println routes
		def server = new Server(8080)
		def context = new Context(server, "/", Context.SESSIONS)
		context.resourceBase = "."
		context.addServlet(TemplateServlet, "*.gsp")
		server.start()
    }
}
