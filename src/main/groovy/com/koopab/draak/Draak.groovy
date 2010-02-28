package com.koopab.draak

import static Thread.currentThread

class Draak { 
    static init(app) {
        def draak = new DraakApp().with {
            app.get = { url, block -> route("GET", url, block) }
            app.post = { url, block -> route("POST", url, block) }
            app.put = { url, block -> route("PUT", url, block) }
            app.delete = { url, block -> route("DELETE", url, block) }
            
            def script = currentThread()
            Thread.start {
                script.join()
                startApp()
            }
        }        
    }
}

