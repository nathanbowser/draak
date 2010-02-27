@Grab(group="com.koopab", module="draak", version="0.1")
import com.koopab.draak.*

Draak.init this

get "/index.html", {
	// Show something
	println "Hello World!"
}

get "/about-us.html", {
    // Show the about us screen
}

get "/hours.html", {
    // Hours screen
}

post "/submit.html", {
	// Save/Edit something
}
