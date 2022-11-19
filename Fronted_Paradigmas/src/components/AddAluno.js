import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label, Col } from 'reactstrap';
import AppNavbar from './AppNavbar';

class AddAluno extends Component {
    base = {
        nome: '',
        matricula: '',
        curso: '',
        avaliacoes:{}
    }

    constructor(props) {
        super(props)
        this.state = {
            item: this.base,
            cadastrado: false
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target
        const value = target.value
        const name = target.name

        let item = { ...this.state.item }
        item[name] = value
        this.setState({ item })
    }

    async handleSubmit(event) {
        event.preventDefault()
        const { item } = this.state

        await fetch("http://localhost:8080/cadastrar-aluno/", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item)
        }).then((response) => {
            if (response.status === 200) {
                this.setState({ cadastrado: true })
            }
        }
        )

        this.setState({
            item: {
                nome: '',
                matricula: '',
                curso: ''
            }
        })

        this.props.history.push("/alunos")
    }

    render() {
        const { item } = this.state;


        return <div>
            <AppNavbar />
            <Container className='square border border-dark mt-1'>
                <h2>Adicionar Aluno</h2>
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup row>
                        <Label for="nome">Nome</Label>
                        <Col sm={10}>
                            <Input type="text" name="nome" id="nome" value={item.nome || ''}
                                onChange={this.handleChange} autoComplete="name" />
                        </Col>

                    </FormGroup>
                    <FormGroup row>
                        <Label for="email">Matricula</Label>
                        <Col sm={10}>
                            <Input type="text" name="matricula" id="matricula" value={item.matricula || ''}
                                onChange={this.handleChange} autoComplete="matricula" />
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Label for="curso">Curso</Label>
                        <Col sm={10}>
                        <Input type="text" name="curso" id="curso" value={item.curso || ''}
                            onChange={this.handleChange} autoComplete="curso" />
                        </Col>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/alunos">Cancel</Button>
                    </FormGroup>

                </Form>
                <span>{this.state.cadastrado ? "Cadastrado" : ""}</span>
            </Container>
        </div>
    }
}
export default AddAluno;