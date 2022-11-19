import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component{
    render(){
        return(
            <>
                <AppNavbar/>
                <Container fluid>
                    <Button color='link'><Link to="/alunos">Alunos</Link></Button>
                    <Button color='link'><Link to="/add">Adicionar Aluno</Link></Button>
                    <Button color='link'><Link to="/addAv">Adicionar Avaliacao</Link></Button>
                </Container>
            </>
        )
    }
}

export default Home