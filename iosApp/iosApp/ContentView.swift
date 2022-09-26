import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewModel = ViewModel()
    
    var body: some View {
        VStack(alignment: .leading){
            Text("Your Todo List")
                .font(.title)
                .padding()
            Color.gray.opacity(0.2)
                .ignoresSafeArea()
                .overlay(
                    HStack{
                        TextField("Enter Todo", text: $viewModel.todo)
                        Divider()
                        Button{
                            viewModel.addTodo()
                        } label: {
                            Image(systemName: "plus")
                                .foregroundColor(.blue)
                                .frame(width: 50,height: 50)
                        }
                    }.padding()
                )
                .clipShape(RoundedRectangle(cornerRadius: 12))
                .frame(height: 50)
                .padding()
            ScrollView{
                LazyVStack{
                    if viewModel.todos.count>0{
                        ForEach(0...viewModel.todos.count-1,id:\.self){i in
                            TodoItem(todo: viewModel.todos[i]){
                                viewModel.deleteTodo(pos: i)
                            }
                        }
                    }
                }.frame(maxHeight: .infinity,alignment: .topLeading)
            }
        }
    }
}

//struct ContentView_Previews: PreviewProvider {
//    static var previews: some View {
//        ContentView()
//    }
//}


extension ContentView{
    class ViewModel : ObservableObject{
        
        @Published private(set) var todos : [Todo] = []
        
        @Published var todo : String = ""
        
        func deleteTodo(pos : Int){
            todoController.deleteTodo(todo: todos[pos])
            todos = todoController.todos as! [Todo]
        }
        
        
        func addTodo(){
            todoController.addTodo(todo: todo)
            todos = todoController.todos as! [Todo]
            todo = ""
        }
        
        private let todoController : TodoController
        init(){
            self.todoController = TodoController()
        }
    }
}
