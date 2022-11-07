import React, { Component } from "react";
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';
import AppNavbar from "./AppNavbar"

class AlunosList extends Component {
    constructor(props) {
        super(props)
        this.state = {
            alunos: []
        }
    }

    async componentDidMount() {
        await fetch('https://635bdd798aa87edd915339ec.mockapi.io/api/alunos/alunos',
            {
                method: 'get'
            }).then((response) => response.json()).then(data => this.setState({
                alunos: data
            }))
    }

    render() {
        const { alunos, isLoading } = this.state
        if (isLoading) {
            return <p>Loading..</p>
        }

        const alunosList = alunos.map(aluno => {
            return (
                <tr key={aluno.matricula}>
                    <td style={{ whiteSpace: 'nowrap' }}>{aluno.nome}</td>
                    <td>{aluno.curso}</td>
                    <td>
                        <ButtonGroup>
                            <Link to= "/verAluno/"
                                state = {{id : aluno.id}}>Ver Aluno</Link>
                        </ButtonGroup>
                    </td>
                </tr>
            )
        })
        //<Button size="sm" color="primary" tag={Link} to={"/verAluno/" + aluno.id}>Ver Aluno</Button> 
        return (
            <div>
                <AppNavbar />
                <Container fluid>
                    <div>
                        <Button color="success" tag={Link} to="/add">Adicionar Aluno</Button>
                    </div>
                    <h3>Alunos</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="30%">Nome</th>
                                <th width="30%">Curso</th>
                                <th width="40%">Ver</th>
                            </tr>
                        </thead>
                        <tbody>
                            {alunosList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        )
    }
}
export default AlunosList