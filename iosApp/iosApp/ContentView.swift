import SwiftUI
import shared

struct ContentView: View {
    private var todosDbController : TodosDBController
    
    @StateObject var viewModel = TodosViewModel(todosDbController: nil)
    
    init(todosDbController: TodosDBController) {
        self.todosDbController = todosDbController
    }
    
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
            }.onAppear{
                viewModel.getTodos()
            }
        }.onAppear{
            viewModel.setTodosDBController(todosDbController: todosDbController)
        }
    }
}

//struct ContentView_Previews: PreviewProvider {
//    static var previews: some View {
//        ContentView()
//    }
//}


extension ContentView{
    @MainActor class TodosViewModel : ObservableObject{
        
        @Published private(set) var todos : [Todo] = []
        
        @Published var todo : String = ""
        
        private var todosDbController : TodosDBController? = nil
        func deleteTodo(pos : Int){
            todosDbController?.deleteTodo(todo: todos[pos])
            getTodos()
        }
        
        
        func addTodo(){
            todosDbController?.addTodo(todoStr: todo)
            getTodos()
            todo = ""
        }
        
        
        func getTodos(){
            todos = todosDbController?.getTodos() ?? []
        }
        
        func setTodosDBController(todosDbController : TodosDBController) {
            self.todosDbController = todosDbController
        }
        
        init(todosDbController: TodosDBController? = nil) {
            self.todosDbController = todosDbController
        }
    
    }
}
