#include "Shape.h"

Shape::Shape(double radius)
{
    area = 3.14 * pow(radius, 2);
    perimeter = 2 * 3.14 * radius;
}

Shape::Shape(double length, double width)
{
    area = length * width;
    perimeter = 2 * (length + width);
}

Shape::Shape(double s1, double s2, double s3)
{
    double s = (s1 + s2 + s3) / 2;
    area = sqrt(s * (s - s1) * (s - s2) * (s - s3));
    perimeter = s1 + s2 + s3;
}

double Shape::getArea()
{
    return area;
}

double Shape::getPerimeter()
{
    return perimeter;
}

std::string Shape::getErrorMessage()
{
    return "Error Message";
}