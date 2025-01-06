//
//  AboutListView.swift
//  iosApp
//
//  Created by Diego Cardoso on 06/01/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared
import SwiftUI


//struct é como uma anotação equivalente a anotação do jetpackCompose
struct AboutListView: View{
    
    //aqui é a estrutura de cada linha
    private struct RowItem: Hashable{
        let title: String
        let subtitle: String
    }
    
    //aqui vamos inicializar as informações que esses itens conterão
    private let items: [RowItem] = {
        //instanciando um objeto da classe Platform
        let platform = Platform()
        //para fazer depuração no AndroidStudio
        platform.logSystemInfo()

        
        var result: [RowItem] = [
            .init(
                title: "Operation System",
                subtitle: "\(platform.osName) \(platform.osVersion)"
            ),
            .init(
                title: "Device",
                subtitle: platform.deviceModel
            ),
            .init(
                title: "Density",
                subtitle: "@\(platform.density)x"
            )
        ]
        return result
    }() 
    
    
    
    var body: some View{
        List{
            ForEach(items, id: \.self){ item in
                VStack(alignment: .leading){
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}


#Preview {
    AboutListView()
}
