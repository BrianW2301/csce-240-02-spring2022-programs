#ifndef BaseEmailHeaderType_H_
#define BaseEmailHeaderType_H_

#include <regex>
#include <string>

class BaseEmailHeaderType
{
    std::string header;
    std::string messageID;
    std::string subject;
    std::string from;
    std::string contentType;
    std::string received;
    std::string contentTransferEncoding;
    std::string date;
    std::string to;

public:
    BaseEmailHeaderType(std::string);
    std::string getMessageID();
    std::string getSubject();
    std::string getFrom();
    std::string getContentType();
    std::string getReceived();
    std::string getContentTransferEncoding();
    std::string getDate();
    std::string getTo();
};

#endif