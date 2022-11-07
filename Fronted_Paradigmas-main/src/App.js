import './App.css';
import React, { Component } from "react"
import { Routes,BrowserRouter as Router,Route } from 'react-router-dom';
import Home from './components/Home';
import AlunosList from './components/AlunosList';
import AddAluno from './components/AddAluno';
import AddAvaliacao from './components/AddAvaliacao';
import VerAluno from './components/VerAluno';

class App extends Component {
    render() {
        return (
            <Router>
                <Routes>    
                    <Route exact path="/" element={<Home/>}/>
                    <Route path="/alunos" element={<AlunosList/>} />
                    <Route path="/add" element={<AddAluno/>} />
                    <Route path="/addAv" element={<AddAvaliacao/>} />
                    <Route path="/verAluno" element={<VerAluno/> } />
                </Routes>
            </Router>
        )
    }


}

export default App;
