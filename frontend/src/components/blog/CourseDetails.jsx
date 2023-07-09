import Back from "../common/back/Back";
import "./CourseDetails.css";
import React, { useEffect, useState } from "react";
import Divider from "@mui/material/Divider";
import Paper from "@mui/material/Paper";
import MenuList from "@mui/material/MenuList";
import MenuItem from "@mui/material/MenuItem";
import ListItemText from "@mui/material/ListItemText";
import ListItemIcon from "@mui/material/ListItemIcon";
import Typography from "@mui/material/Typography";
import PlayLesson from "@mui/icons-material/PlayLesson";
import ContentCopy from "@mui/icons-material/ContentCopy";
import ContentPaste from "@mui/icons-material/ContentPaste";
import Cloud from "@mui/icons-material/Cloud";
import Team from "./../team/Team";
import Testimonal from "../home/testimonal/Testimonal";
import Heading from "../common/heading/Heading";
import QuizIcon from '@mui/icons-material/Quiz';

const CourseDetails = () => {
  const [number, setNumber] = useState(1);






  return (
    <>
      <Back title="Course Name" />
      <div className="d-flex">
        <div style={{ width: "320px", marginLeft:'20px'}}>
          <Paper sx={{ width: 320, maxWidth: "100%" }}>
            <MenuList>
              <MenuItem onClick={()=>setNumber(1)}>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 1</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem onClick={()=>setNumber(2)}>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 2</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem onClick={()=>setNumber(3)}>
                <ListItemIcon>
                  <QuizIcon fontSize="small" />
                </ListItemIcon>
                <ListItemText>Assessment 1</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem onClick={()=>setNumber(4)}>
                <ListItemIcon>
                  <QuizIcon fontSize="small" />
                </ListItemIcon>
                <ListItemText>Task 1</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem onClick={()=>setNumber(3)}>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 3</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 4</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 5</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 6</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 7</ListItemText>
              </MenuItem>
              <Divider />
              <MenuItem>
                <ListItemIcon>
                  <PlayLesson fontSize="small" />
                </ListItemIcon>
                <ListItemText>Chapter 8</ListItemText>
              </MenuItem>
         
             
              
            </MenuList>
          </Paper>
        </div>

        <section className="blog ">
          <div className="course-details">
            {number == 1 && (
              <>
                <Heading
                  subtitle="Chapter 1"
                  title="Begginer skills for football"
                />
                <iframe
                  width="100%"
                  height="600"
                  src="https://www.youtube.com/embed/5fl248V4tIU"
                  frameborder="0"
                  allowfullscreen></iframe>
              </>
            )}
            {number == 2 && (
              <>
              <Heading
                  subtitle="Chapter 2"
                  title="Begginer skills for football"
                />
                <iframe
                  src="https://www.africau.edu/images/default/sample.pdf"
                  width="1000"
                  height="700"></iframe>
              </>
            )}
            {number ==3 && <>
                <Heading
                  subtitle="Chapter 3"
                  title="Assessment 1"
                />
                <iframe src="https://docs.google.com/forms/d/e/1FAIpQLSdKpLe6jw9lTAfja9vYltLXDtC3zwIxBsmBV6oDL1WRh4mFwA/viewform?embedded=true" width="1000" height="700" frameborder="0" marginheight="0" marginwidth="0">Loading…</iframe>
            </>}
            {number ==4 && <>
                <Heading
                  subtitle="Chapter 4"
                  title="Complete the following task"
                />
              
                <br/>
                <p>Do a Penalty kick and Upload the video below</p>
               <br/><br/>
  <input type="file" id="myFile" name="filename"/>



                

            </>}

            <Team />
            <Testimonal />
          </div>
        </section>
      </div>
    </>
  );
};

export default CourseDetails;
