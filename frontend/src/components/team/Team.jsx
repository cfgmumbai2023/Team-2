import React from "react"
import Back from "../common/back/Back"
import TeamCard from "./TeamCard"
import "./team.css"
import Awrapper from "../about/Awrapper"
import "../about/about.css"
import Heading from "../common/heading/Heading"

const Team = () => {
  return (
    <>
      <section className='team padding'>
      <Heading subtitle='Authors'  />
        <div className='container grid'>

          <TeamCard />
        </div>
      </section>
     
    </>
  )
}

export default Team
