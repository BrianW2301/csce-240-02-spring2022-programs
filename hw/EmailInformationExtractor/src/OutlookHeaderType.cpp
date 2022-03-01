#include "OutlookHeaderType.h"

OutlookHeaderType::OutlookHeaderType(std::string header) : BaseEmailHeaderType(header)
{
    std::smatch matches;

    std::regex reg("Authentication-Results: (.+)");
    regex_search(header, matches, reg);
    authenticationResults = matches[1];

    reg = "CC: (.+)";
    regex_search(header, matches, reg);
    CC = matches[1];

    reg = "Thread-Topic: (.+)";
    regex_search(header, matches, reg);
    threadTopic = matches[1];

    reg = "Thread-Index: (.+)";
    regex_search(header, matches, reg);
    threadIndex = matches[1];

    reg = "References: (.+)";
    regex_search(header, matches, reg);
    references = matches[1];

    reg = "In-Reply-To: (.+)";
    regex_search(header, matches, reg);
    inReplyTo = matches[1];

    reg = "Accept-Language: (.+)";
    regex_search(header, matches, reg);
    acceptLanguage = matches[1];

    reg = "Content-Language: (.+)";
    regex_search(header, matches, reg);
    contentLanguage = matches[1];

    reg = "X-MS-Exchange-Organization-SCL: (.+)";
    regex_search(header, matches, reg);
    XMSExchangeOrganizationSCL = matches[1];

    reg = "X-MS-Has-Attach: (.+)";
    regex_search(header, matches, reg);
    XMSHasAttach = matches[1];
}

std::string OutlookHeaderType::getAuthenticationResults()
{
    return authenticationResults;
}
std::string OutlookHeaderType::getCC()
{
    return CC;
}
std::string OutlookHeaderType::getThreadTopic()
{
    return threadTopic;
}
std::string OutlookHeaderType::getThreadIndex()
{
    return threadIndex;
}
std::string OutlookHeaderType::getReferences()
{
    return references;
}
std::string OutlookHeaderType::getInReplyTo()
{
    return inReplyTo;
}
std::string OutlookHeaderType::getAcceptLanguage()
{
    return acceptLanguage;
}
std::string OutlookHeaderType::getContentLanguage()
{
    return contentLanguage;
}
std::string OutlookHeaderType::getXMSExchangeOrganizationSCL()
{
    return XMSExchangeOrganizationSCL;
}
std::string OutlookHeaderType::getXMSHasAttach()
{
    return XMSHasAttach;
}
