//
//  FxListView.swift
//  iosApp
//
//  Created by Daniel Mandea on 19.08.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI
import Shared
    
struct FxListView: View {
    
    @StateViewModel
    var viewModel = FxListViewModel(
        fxRepository: KoinDependencies().fxRepository
    )

    var body: some View {
        NavigationView {
            List(viewModel.objects, id: \.self) { item in
                NavigationLink {
                    Text(item.to)
                } label: {
                    VStack {
                        Text(item.date)
                        Text(item.from)
                    }
                }
            }
        }
        
    }
}

#Preview {
    FxListView()
}
