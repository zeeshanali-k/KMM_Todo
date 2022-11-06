import SwiftUI
import shared

@main
struct iOSApp: App {
    
    private let dbModule : DBModule = DBModule()
    
	var body: some Scene {
		WindowGroup {
            ContentView(todosDbController: dbModule.todosDBController)
		}
	}
}
