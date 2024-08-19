import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        KoinKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            TabView {
                ListView()
                    .tabItem {
                        Label("Museum", systemImage: "list.dash")
                    }
                
                FxListView()
                    .tabItem {
                        Label("Fx", systemImage: "square.and.pencil")
                    }
            }
            
        }
    }
}
