import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label, Col } from 'reactstrap';
import AppNavbar from './AppNavbar';

class AddAvaliacao extends Component {
    base = {
        nome: '',
        peso: 0,
        nota: undefined
    }
    constructor(props) {
        super(props)
        this.state = {
            item: this.base,
            matriculas: [],
            aluno_selecionado: '',
            disciplina: '',
            array_num: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        await fetch('http://localhost:8080/listar-alunos',
            {
                method: 'GET'
            }).then((response) => response.json()).then(data => this.setState({
                matriculas: data
            }))
            console.log(this.state.matriculas)
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
        
        let user = this.state.matriculas.filter((e)=>
            e.matricula === this.state.aluno_selecionado
        )
        
        if(user[0].avaliacoes.hasOwnProperty(this.state.disciplina)){
            user[0].avaliacoes[this.state.disciplina].push(this.state.item)
        }else{
            user[0].avaliacoes = Object.assign(user[0].avaliacoes,{
                [this.state.disciplina]: [this.state.item]
            })
        }
        
        event.preventDefault()

        console.log(user[0].id);

        await fetch("http://localhost:8080/cadastrar-aluno/", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user[0])
        }).then(response => console.log(response.status)) 
        this.setState({
            item:this.base,
            aluno_selecionado: '',
            disciplina: '',
        })
    }

    render() {

        const { item } = this.state

        return <div>
            <AppNavbar />
            <Container className='square border border-dark mt-1'>
                <h2>Adicionar Atividade</h2>
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup row>
                        <Label for="matricula">Matricula</Label>
                        <Col sm={10}>
                            <Input type="select" name="aluno_selecionado" id="aluno_selecionado"
                                onChange={(e) => this.setState({ aluno_selecionado: e.target.value })} value={this.state.aluno_selecionado || ''}>
                                    <option>Matricula</option>
                                    {this.state.matriculas.map((matricula) =>
                                        <option key={matricula.matricula}>{matricula.matricula}</option>)}
                            </Input>
                        </Col>
                    </FormGroup>

                    <FormGroup row>
                        <Label for="disciplina">Disciplina</Label>
                        <Col sm={10}>
                            <Input type="select" name="disciplina" id="disciplina"
                                onChange={(e) => this.setState({ disciplina: e.target.value })} value={this.state.disciplina || ''}>
                                <option>Disciplina</option>
                                <option>Paradigmas de Programacao</option>
                                <option>Arquitetura de computadores</option>
                                <option>Engenharia de Software</option>
                                <option>Pesquisa e Ordenacao</option>
                            </Input>
                        </Col>
                    </FormGroup>

                    <FormGroup row>
                        <Label for="nome">Nome da Atividade</Label>
                        <Col sm={10}>
                            <Input type="text" name="nome" id="nome" onChange={this.handleChange} value={item.nome || ''} />
                        </Col>
                    </FormGroup>

                    <FormGroup row>
                        <Label for="peso">Peso da Atividade</Label>
                        <Col sm={10}>
                            <Input type="select" name="peso" id="peso" onChange={this.handleChange} value={item.peso || ''}>
                                <option>0</option>
                                {this.state.array_num.map((i) => {
                                    return (<option key={i}>{i}</option>)
                                })}
                            </Input>
                        </Col>
                    </FormGroup>

                    <FormGroup row>
                        <Label for="nota">Nota da Atividade</Label>
                        <Col sm={10}>
                            <Input type="select" name="nota" id="nota" onChange={this.handleChange} value={item.nota || ''}>
                                <option>0</option>
                                {this.state.array_num.map((i) => {
                                    return (<option key={i}>{i}</option>)
                                })}
                            </Input>
                        </Col>
                    </FormGroup>

                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/alunos">Cancel</Button>
                    </FormGroup>

                </Form>
            </Container>
        </div>
    }

}

export default AddAvaliacao