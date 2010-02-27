package com.koopab.draak

class DraakApp {
    def routes = [:]

    def route(method, url, block = null) {
        routes[method] = routes[method] ?: []
        routes[method] << new Expando([url : url, block : block])
    }
    
    def startApp() {
        println "Starting Draak w/ the following routes:"
        println routes
    }
}
