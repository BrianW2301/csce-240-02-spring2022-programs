#include <iostream>
#include <string>
#include <chrono>

using namespace std;

int factorial(int num)
{
    int ans = 1;
    for (int i = num; i > 0; i--)
    {
        ans *= i;
    }
    return ans;
}

int choose(int n, int r)
{
    int ans = factorial(n) / (factorial(r) * (factorial(n - r)));
    return ans;
}

int main(int argc, char *argv[])
{
    if (argc == 1)
    {
        cout << "No input";
    }
    else if (argc == 2)
    {
        try
        {
            if (stoi(argv[1]) < 0 || stod(argv[1]) != stoi(argv[1]))
            {
                cout << "Input must be a positive integer" << endl;
            }
            else

            {
                // Start clock
                auto start = std::chrono::steady_clock::now();
                // Run factorial function
                int ans = factorial(stoi(argv[1]));
                // End clock
                auto end = std::chrono::steady_clock::now();
                // Define the time elapsed as the difference between the start and end times
                std::chrono::duration<double> diff_in_seconds = end - start;

                cout << ans << endl;
                cout << "elapsed time (in sec): " << diff_in_seconds.count() << "s\n";
            }
        }
        catch (...)
        {
            cout << "Input must be a positive integer" << endl;
        }
    }
    else if (argc == 3)
    {
        try
        {
            if (stoi(argv[1]) < 0 || stod(argv[1]) != stoi(argv[1]) || stoi(argv[2]) < 0 || stod(argv[2]) != stoi(argv[2]))
            {
                cout << "Input must be a positive integer" << endl;
            }
            else

            {
                // Start clock
                auto start = std::chrono::steady_clock::now();
                // Run choose function
                int ans = choose(stoi(argv[1]), stoi(argv[2]));
                // End clock
                auto end = std::chrono::steady_clock::now();
                // Define the time elapsed as the difference between the start and end times
                std::chrono::duration<double> diff_in_seconds = end - start;

                cout << "Answer: " << ans << endl;
                cout << "elapsed time (in sec): " << diff_in_seconds.count() << "s\n";
            }
        }
        catch (...)
        {
            cout << "Input must be a positive integer" << endl;
        }
    }
    else if (argc > 3)
    {
        cout << "Too many arguments";
    }

    return 0;
}