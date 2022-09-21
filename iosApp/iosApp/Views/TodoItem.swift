//
//  TodoItem.swift
//  iosApp
//
//  Created by Zeeshan Ali on 20/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TodoItem: View {
    
    var todo : Todo
    var onItemDeleted : ()->()
    
    var body: some View {
        HStack(alignment:.center){
            VStack(alignment:.leading){
                Text(todo.todo)
                    .font(.body)
                Text(todo.date)
                    .font(.caption)
            }
            Spacer()
            Button{
                onItemDeleted()
            } label: {
                Image(systemName: "trash")
                    .frame(width: 50,height: 50)
                    .foregroundColor(.red)
            }
            
        }.padding()
    }
}

//struct TodoItem_Previews: PreviewProvider {
//    static var previews: some View {
//        TodoItem()
//    }
//}
