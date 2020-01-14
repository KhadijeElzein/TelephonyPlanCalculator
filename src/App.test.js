import React from 'react';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import api from './services/api'
import Main from './pages/Main';
import Header from './components/Header'
import Footer from './components/Footer'
import Adapter from 'enzyme-adapter-react-16';
import Table from 'react-bootstrap/Table';
import Form from 'react-bootstrap/Form';
import {configure,mount } from 'enzyme';

configure({adapter: new Adapter()});

test('show component Main', () => {  
  const component = mount(<Main/>);
  expect(component.find(Form).exists()).toBeTruthy();
});

test('show component Header', () => {  
  const component = mount(<Header/>);
  expect(component.find('header').exists()).toBeTruthy();
});

test('show component Footer', () => {  
  const component = mount(<Footer/>);
  expect(component.find('footer').exists()).toBeTruthy();
});

test('returns data when post', () =>{
  axios.defaults.adapter = require('axios/lib/adapters/http');
  var mock = new MockAdapter(axios);
  const object = {
    source : "011",
    destination : "016",
    minutes : "20",
    plan : "1"
  }

  const data = { priceWithPlan:0, priceWithoutPlan:38};
  mock.onPost('http://localhost:8080//v1.0/telephony-plan-calculator/compute',object)
  .reply(200,data);
  api.post(0, 'any').then(response => {
    expect(response).toEqual(data);
    done();
  });
});

test('should capture minutes correctly onChange',()=>{
  const component = mount(<Main/>);
  const input = component.find('[name="minutes"]').at(1);
  input.instance().value = "20";
  input.simulate('change');
  expect(component.state().params.minutes).toEqual("20");
});

test('should capture source correctly onChange',()=>{
  const component = mount(<Main/>);
  const input = component.find('[name="source"]').at(1);
  const optionDDD11 = component.find('#ddd11source');
  optionDDD11.instance().selected = true;
  input.simulate('change');
  expect(component.state().params.source).toEqual("011");
});

test('should capture destination correctly onChange',()=>{
  const component = mount(<Main/>);
  const input = component.find('[name="destination"]').at(1);
  const optionDDD11 = component.find('#ddd11destination');
  optionDDD11.instance().selected = true;
  input.simulate('change');
  expect(component.state().params.destination).toEqual("011");
});

test('should capture plan correctly onChange',()=>{
  const component = mount(<Main/>);
  const input = component.find('[name="plan"]').at(1);
  const optionPlan1 = component.find('#plan1');
  optionPlan1.instance().selected = true;
  input.simulate('change');
  expect(component.state().params.plan).toEqual("1");
});

test('Should print valid data on console for valid form submission', () => {
  const object = {
    source : "011",
    destination : "016",
    minutes : "20",
    plan : "1"
  }
  const component = mount(<Main/>);
  console.log = jest.fn();
  component.setState({params: object});
  component.find("#form").at(1).simulate('submit');
  expect(console.log).toHaveBeenLastCalledWith(object);
});

test('Should print errors on console for invalid form submission', () => {
  const object = {
    source : "",
    destination : "016",
    minutes : "-20",
    plan : "1"
  }
  const errors = {
    sourceError:"Selecione um DDD de origem.",
    minutesError:"No campo minutos o número deve ser positivo."  
  }
  const component = mount(<Main/>);
  console.log = jest.fn();
  component.setState({params: object,errors:errors});
  component.find("#form").at(1).simulate('submit');
  expect(console.log).toHaveBeenLastCalledWith(errors);
});

test('show table when valid result', () => {  
  const result = {
    data: {
      priceWithoutPlan: 38, 
      priceWithPlan: 0},
    status: 200
    }
  const component = mount(<Main/>);
  component.setState({result: result});
  expect(component.find(Table).exists()).toBeTruthy();
});

test('show span when invalid result', () => {  
  const result = {
    data: {
      priceWithoutPlan: 38, 
      priceWithPlan: 0},
    status: 204
    }
  const component = mount(<Main/>);
  component.setState({result: result});
  expect(component.find('span').exists()).toBeTruthy();
});

