import React from 'react';
import { Container, Row, Col, Card} from 'react-bootstrap';

const CoursePathwayPage = () => {
  const courses = [
    {
      id: 1,
      title: 'Country Level Coach',
      description: '',
      duration: '4 weeks',
      level: 'Beginner',
    },
    {
      id: 2,
      title: 'Subcontinet Level',
      description: 'Build a solid foundation in web development.',
      duration: '6 weeks',
      level: 'Intermediate',
    },
    {
      id: 3,
      title: 'FIFA Coach',
      description: 'Become an expert in React and build modern web applications.',
      duration: '8 weeks',
      level: 'Advanced',
    },
    // Add more courses as needed
  ];

  return (
    <Container>
      <h1 className="mb-4">Course Pathway</h1>
      <Row xs={1} md={2} lg={3} className="g-4">
        {courses.map((course) => (
          <Col key={course.id}>
            <Card>
              <Card.Body>
                <Card.Title>{course.title}</Card.Title>
                <Card.Text>{course.description}</Card.Text>
                <Card.Text>Duration: {course.duration}</Card.Text>
                <Card.Text>Level: {course.level}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default CoursePathwayPage;
