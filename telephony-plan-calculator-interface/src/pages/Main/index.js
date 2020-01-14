import React,{Component} from 'react';
import api from '../../services/api'
import Container from 'react-bootstrap/Container'
import Col from 'react-bootstrap/Col'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import Table from 'react-bootstrap/Table'

const initialState = {
    params: {
        source:"",
        destination:"",
        minutes:"",
        plan:"",
        },
        result: null,
        errors:{
            sourceError:"",
            destinationError:"",
            minutesError:"",
            planError:"",
        }

}
export default class Main extends Component{   
    state = initialState;
    
    validate = () =>{
        let sourceError = "";
        let destinationError = "";
        let minutesError = "";
        let planError = "";

        if(!this.state.params.source)
            sourceError="Selecione um DDD de origem.";

        if(!this.state.params.destination)
            destinationError="Selecione um DDD de destino.";
        
        if(isNaN(this.state.params.minutes))
            minutesError = "O campo minutos deve ser um número.";
        
        if(this.state.params.minutes < 0)
            minutesError = "No campo minutos o número deve ser positivo.";
        
        if(!this.state.params.minutes)
            minutesError = "Digite um valor para o campo minutos.";
        
        if(!this.state.params.plan)
            planError="Selecione um plano telefônico.";
        
        if(sourceError || destinationError || minutesError || planError){
            const errors = {...this.state.errors, sourceError:sourceError, destinationError: destinationError,
                           minutesError:minutesError,planError:planError};
            this.setState({...this.state,errors});
            return false;
        }
        return true;
    }

    handleChange = ({ target }) => {
        const param = {...this.state.params, [target.name]: target.value};
        this.setState({...this.state, params: param});
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const isValid = this.validate();
        if(isValid){
            const object = {
                source : this.state.params.source,
                destination : this.state.params.destination,
                minutes : this.state.params.minutes,
                plan : this.state.params.plan
            }
            api.post('/compute', object)
            .then(res=>{
            this.setState({...this.state,result:res});
            })
            //clear form
            this.setState(initialState);
            console.log(object);
        }
        else console.log(this.state.errors);
    }

      
    render(){
        return(
        <Container>
            <Col md={12} className="text-center text-info">
                <h4>Calcule o valor da sua ligação com a Telzir.</h4>
            </Col>
            
            <Col md={12}>
		        <Form onSubmit = { this.handleSubmit } id="form">
                    <Form.Row>
                        <Form.Group as={Col} md={6} xs={12}>
                            <Form.Label htmlFor="source">DDD Origem</Form.Label>
                            <Form.Control as="select" name="source" 
                            value={this.state.params.source} onChange={this.handleChange}>
                                <option value="" id="selectsource">Selecione</option>
						        <option value="011" id="ddd11source">011</option>
						        <option value="016" id="ddd16source">016</option>
						        <option value="017" id="ddd17source">017</option>
						        <option value="018" id="ddd18source">018</option>
                            </Form.Control>
                            <div className="text-danger font-small">{this.state.errors.sourceError}</div>
                        </Form.Group>
                       
                        <Form.Group as={Col} md={6} xs={12}>
                            <Form.Label htmlFor="destination">DDD Destino</Form.Label>
                            <Form.Control as="select" name="destination" 
                            value={this.state.params.destination} onChange={this.handleChange}>
                                <option value="" id="selectdestination">Selecione</option>
						        <option value="011" id="ddd11destination">011</option>
						        <option value="016" id="ddd16destination">016</option>
						        <option value="017" id="ddd17destination">017</option>
						        <option value="018" id="ddd18destination">018</option>
                            </Form.Control>
                            <div className="text-danger font-small">{this.state.errors.destinationError}</div>
                        </Form.Group>
                    </Form.Row>
                    <Form.Row>
                        <Form.Group as={Col}>
                            <Form.Label htmlFor="minutes">Minutos da Ligação</Form.Label>
                            <Form.Control name="minutes" value={this.state.params.minutes}  
                            onChange={this.handleChange}/>
                            <div className="text-danger font-small">{this.state.errors.minutesError}</div>
                        </Form.Group>
                        <Form.Group as={Col} md={6} xs={12}>
                            <Form.Label htmlFor="plan">Plano FaleMais</Form.Label>
                            <Form.Control as="select" name="plan"
                            value={this.state.params.plan} onChange={this.handleChange}>
                                <option value="" id="selectplan">Selecione</option>
                                <option value="1" id="plan1">FaleMais30</option>
                                <option value="2" id="plan2">FaleMais60</option>
                                <option value="3" id="plan3">FaleMais120</option>
                            </Form.Control>
                            <div className="text-danger font-small">{this.state.errors.planError}</div>
                        </Form.Group>
                    </Form.Row>
                    <Form.Row>
                        <Form.Group as={Col}> 
                            <Button variant="primary" type="submit">Calcular</Button>
                        </Form.Group>
                    </Form.Row>
		        </Form>
            </Col>
            { this.state.result && this.state.result.status !== 204 &&
            <Table responsive className="table-bordered">
                <thead className="thead-light">
				    <tr>
					    <th scope="col">Valor da Ligação com o plano</th>
						<th scope="col">Valor da Ligação sem o plano</th>
					</tr>
				</thead>
			    <tbody>
				    <tr>
					    <td>R$ {this.state.result.data.priceWithPlan}</td>
						<td>R$ {this.state.result.data.priceWithoutPlan}</td>
					</tr>
				</tbody>
			</Table>
            }
            {this.state.result && this.state.result.status === 204 &&
             <div>
                <span className="text-danger">
                    Não há dados para essa ligação. Rever os dados preenchidos
                </span>
            </div>
            }
     </Container>);
    }
}