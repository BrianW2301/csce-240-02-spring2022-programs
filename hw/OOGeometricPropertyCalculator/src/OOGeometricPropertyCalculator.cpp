#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include "Shape.cpp"
#include "Circle.cpp"
#include "Triangle.cpp"
#include "Rectangle.cpp"

using namespace std;

int main(int argc, char *argv[])
{

    string file_name = "..\\data\\input.txt";
    string out_file_name = "..\\data\\output.txt";
    string line;
    string shape = "NULL";
    string answer;

    int measurementType = stoi(argv[1]);
    cout << measurementType << endl;

    ifstream myfile(file_name);
    if (myfile.is_open())
    {

        getline(myfile, line);

        myfile.close();

        if (line.substr(0, 6) == "CIRCLE")
        {
            answer = "CIRCLE ";
            if (measurementType == 1)
                answer += "AREA ";
            else
                answer += "PERIMETER ";
            double radius = stoi(line.substr(7, line.length()));
            Circle shape(radius);
            if (measurementType == 1)
                answer += to_string(shape.getArea());
            else
                answer += to_string(shape.getPerimeter());
        }
        else if (line.substr(0, 8) == "TRIANGLE")
        {
            answer = "TRIANGLE ";
            if (measurementType == 1)
                answer += "AREA ";
            else
                answer += "PERIMETER ";

            double s1;
            double s2;
            double s3;

            istringstream iss(line);
            iss >> line >> s1 >> s2 >> s3;
            Triangle shape(s1, s2, s3);
            if (measurementType == 1)
                answer += to_string(shape.getArea());
            else
                answer += to_string(shape.getPerimeter());
        }
        else if (line.substr(0, 9) == "RECTANGLE")
        {
            answer = "RECTANGLE ";
            if (measurementType == 1)
                answer += "AREA ";
            else
                answer += "PERIMETER ";
            double length;
            double width;

            istringstream iss(line);
            iss >> line >> length >> width;
            Rectangle shape(length, width);
            if (measurementType == 1)
                answer += to_string(shape.getArea());
            else
                answer += to_string(shape.getPerimeter());
        }
        else
        {
            answer = "invalid imput";
        }

        fstream myFile;
        myFile.open(out_file_name, ios::out);
        if (myFile.is_open())
        {
            myFile << answer;
            myFile.close();
        }
        else
            cout << "Unable to open output file - " << file_name << endl;
    }
    else
        cout << "Unable to open input file - " << file_name << endl;
    return 0;
}