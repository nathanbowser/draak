class Draak { 
    static init(app) {
        def draak = new DraakApp().with {
            app.get = { url, block -> route("GET", url, block) }
            app.post = { url, block -> route("POST", url, block) }
            app.put = { url, block -> route("PUT", url, block) }
            app.delete = { url, block -> route("DELETE", url, block) }
            
            //Is this the best way to start the app, after the script has been processed?
            addShutdownHook { startApp() }
        }        
    }
}

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
