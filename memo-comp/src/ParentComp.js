import React, { Component } from 'react'
import MemoComp from './MemoComp'

export class ParentComp extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         name:'sushmitha'
      }
    }
    componentDidMount(){
      setInterval(()=>{
        this.setInterval({
            name:'sushmitha'
        })
      },2000)
    }
    
  render() {
    console.log("Parent Component")
    return (

      <div>ParentComp
        <MemoComp name={this.state.name}/>
      </div>
    )
  }
}

export default ParentComp