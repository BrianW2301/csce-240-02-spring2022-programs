#ifndef OutlookHeaderType_H_
#define OutlookHeaderType_H_

#include "BaseEmailHeaderType.h"

class OutlookHeaderType : public BaseEmailHeaderType
{
    std::string authenticationResults;
    std::string CC;
    std::string threadTopic;
    std::string threadIndex;
    std::string references;
    std::string inReplyTo;
    std::string acceptLanguage;
    std::string contentLanguage;
    std::string XMSHasAttach;
    std::string XMSExchangeOrganizationSCL;

public:
    OutlookHeaderType(std::string);
    std::string getAuthenticationResults();
    std::string getCC();
    std::string getThreadTopic();
    std::string getThreadIndex();
    std::string getReferences();
    std::string getInReplyTo();
    std::string getAcceptLanguage();
    std::string getContentLanguage();
    std::string getXMSHasAttach();
    std::string getXMSExchangeOrganizationSCL();
};

#endif