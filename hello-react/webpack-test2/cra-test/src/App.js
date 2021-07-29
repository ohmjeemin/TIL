import logo from './logo.svg';
import './App.css';
import TodoList from './TodoList';


function App() {
    console.log(`NODE_ENV = ${process.env.NODE_ENV}`)
  return (
    <div className="App">
      <TodoList />
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          jimny's react study
        </a>
      </header>
    </div>
  );
}

export default App;
