//
//  AboutScreen.swift
//  iosApp
//
//  Created by Diego Cardoso on 06/01/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle("Sobre o dispositivo ")
        }
    }
}

#Preview {
    AboutScreen()
}
