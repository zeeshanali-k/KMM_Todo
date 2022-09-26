//
//  Swipeable.swift
//  iosApp
//
//  Created by Zeeshan Ali on 25/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
typealias FrontView<V> = Group<V> where V:View
typealias BackView<V> = Group<V> where V:View

struct Swipeable<Content: View, BackContent: View>: View {
    
    private var content: () -> TupleView<(FrontView<Content>, BackView<BackContent>)>
    @State private var offset = CGSize.zero
    
    private let onAction: () -> ()
    
    init(@ViewBuilder content: @escaping () -> TupleView<(FrontView<Content>, BackView<BackContent>)>, onAction: @escaping () -> Void) {
        self.content = content
        self.onAction = onAction
        self.content = content
    }
    
    var body: some View {
        let (frontView, backView) = self.content().value
        
        return GeometryReader { (geometry) in
            ZStack {
                backView
                frontView
                    .offset(self.offset)
                    .gesture(DragGesture(minimumDistance: 30, coordinateSpace: .local)
                                .onChanged { gestrue in
                                    if gestrue.translation.width < 0  {
                                        self.offset.width = gestrue.translation.width
                                    }
                                    print(offset)
                                }
                                .onEnded { value in
                                    if value.translation.width < 0 {
                                        self.offset.width -= geometry.size.width
                                        onAction()
                                    }
                                }
                    )
            }
        }
        .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity)
        .animation(.spring())
    }
}

//
//struct Swipeable_Previews: PreviewProvider {
//    static var previews: some View {
//        Swipeable()
//    }
//}
