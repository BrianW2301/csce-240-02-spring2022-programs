#include "BaseEmailHeaderType.h"

BaseEmailHeaderType::BaseEmailHeaderType(std::string header)
{
    this->header = header;
    std::smatch matches;

    std::regex reg("Subject: (.+)");
    regex_search(header, matches, reg);
    subject = matches[1];

    reg = "Message-ID: (.+)";
    regex_search(header, matches, reg);
    messageID = matches[1];

    reg = "From: (.+)";
    regex_search(header, matches, reg);
    from = matches[1];

    reg = "To: (.+)";
    regex_search(header, matches, reg);
    to = matches[1];

    reg = "Date: (.+)";
    regex_search(header, matches, reg);
    date = matches[1];

    reg = "Content-Type: (.+)";
    regex_search(header, matches, reg);
    contentType = matches[1];

    reg = "Received: (.+)";
    regex_search(header, matches, reg);
    received = matches[1];

    reg = "Content-Transfer-Encoding: (.+)";
    regex_search(header, matches, reg);
    contentTransferEncoding = matches[1];
}

std::string BaseEmailHeaderType::getMessageID()
{
    return messageID;
}
std::string BaseEmailHeaderType::getSubject()
{
    return subject;
}
std::string BaseEmailHeaderType::getFrom()
{
    return from;
}
std::string BaseEmailHeaderType::getContentType()
{
    return contentType;
}
std::string BaseEmailHeaderType::getReceived()
{
    return received;
}
std::string BaseEmailHeaderType::getContentTransferEncoding()
{
    return contentTransferEncoding;
}
std::string BaseEmailHeaderType::getDate()
{
    return date;
}
std::string BaseEmailHeaderType::getTo()
{
    return to;
}