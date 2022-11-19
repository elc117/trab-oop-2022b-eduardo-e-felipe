import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { Button, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';
import AppNavbar from './AppNavbar';
/*
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
*/
const VerAluno = (props) => {
    const location = useLocation()
    const [Aluno, setAluno] = useState({
        nome: undefined,
        matricula: undefined,
        curso: undefined,
        avaliacoes: {},
        id: undefined
    })
    const { id } = location.state

    useEffect(() => {
        async function fetchData() {
            await fetch("http://localhost:8080/buscar-aluno/" + id,
                { method: "GET" }).then(
                    response => response.json()
                ).then(data => setAluno(data))
        }
        fetchData()
    }, [id])

    return (
        <div>
            <AppNavbar />
            <Container fluid>
                <h3>Nome: {Aluno.nome}</h3>
                {Object.keys(Aluno.avaliacoes).map((disciplina) => {
                    console.log();
                    return (
                        <>
                            <h4 className="mt-4">Disciplina: {disciplina}</h4>
                            <Table className="mt-2 w-50">
                                <thead>

                                    <tr>
                                        <th width="40%">Atividade</th>
                                        <th width="30%">Peso</th>
                                        <th width="30%">Nota</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        Aluno.avaliacoes[disciplina].map(atividades => {
                                            return(<>
                                                <tr key={atividades.nome}>
                                                    <td>{atividades.nome}</td>
                                                    <td>{atividades.peso}</td>
                                                    <td>{atividades.nota}</td>
                                                </tr>
                                            </>)
                                        })
                                    }
                                </tbody>
                            </Table>
                        </>

                    )
                })}



            </Container>
            <Button color="success" tag={Link} to="/alunos">Voltar</Button>
                <a href={'http://localhost:8080/gerar-relatorio/'+id}>Gerar Relatorio</a>
            
        </div>

    )
}

export default VerAluno