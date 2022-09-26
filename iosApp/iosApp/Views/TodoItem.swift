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
        Swipeable{
            FrontView{
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
            BackView{
                HStack{
                    Spacer().background(Color.red)
                    Image(systemName: "trash")
                        .foregroundColor(.red)
                        .background(Color.red)
                }.frame(height: 100)
            }
        } onAction: {
            onItemDeleted()
        }
    }
}

struct TodoItem_Previews: PreviewProvider {
    static var previews: some View {
        TodoItem(todo: Todo(id: 1, todo: "Test", date: "12-12-2022", isDone: false), onItemDeleted: {
            
        })
    }
}
