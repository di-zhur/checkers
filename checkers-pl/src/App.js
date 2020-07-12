import React from 'react';
import './App.css';
import Col from "react-bootstrap/Col";
import Table from "react-bootstrap/Table";

function App() {
  return (
    <div>
      <Col md={6}>
        <h4>Checkers:</h4>
        <Table bordered size="sm" responsive="lg" >
          <tbody>
          <tr>
            <td>1,1</td>
            <td>1,2</td>
            <td>1,3</td>
            <td>1,4</td>
            <td>1,5</td>
            <td>1,6</td>
            <td>1,7</td>
            <td>1,8</td>
          </tr>
          <tr>
            <td>2,1</td>
            <td>2,2</td>
            <td>2,3</td>
            <td>2,4</td>
            <td>2,5</td>
            <td>2,6</td>
            <td>2,7</td>
            <td>2,8</td>
          </tr>
          <tr>
            <td>3,1</td>
            <td>3,2</td>
            <td>3,3</td>
            <td>3,4</td>
            <td>3,5</td>
            <td>3,6</td>
            <td>3,7</td>
            <td>3,8</td>
          </tr>
          <tr>
            <td>4,1</td>
            <td>4,2</td>
            <td>4,3</td>
            <td>4,4</td>
            <td>4,5</td>
            <td>4,6</td>
            <td>4,7</td>
            <td>4,8</td>
          </tr>
          <tr>
            <td>5,1</td>
            <td>5,2</td>
            <td>5,3</td>
            <td>5,4</td>
            <td>5,5</td>
            <td>5,6</td>
            <td>5,7</td>
            <td>5,8</td>
          </tr>
          <tr>
            <td>6,1</td>
            <td>6,2</td>
            <td>6,3</td>
            <td>6,4</td>
            <td>6,5</td>
            <td>6,6</td>
            <td>6,7</td>
            <td>6,8</td>
          </tr>
          <tr>
            <td>7,1</td>
            <td>7,2</td>
            <td>7,3</td>
            <td>7,4</td>
            <td>7,5</td>
            <td>7,6</td>
            <td>7,7</td>
            <td>7,8</td>
          </tr>
          <tr>
            <td>8,1</td>
            <td>8,2</td>
            <td>8,3</td>
            <td>8,4</td>
            <td>8,5</td>
            <td>8,6</td>
            <td>8,7</td>
            <td>8,8</td>
          </tr>
          </tbody>
        </Table>
      </Col>
    </div>
  );
}

export default App;
