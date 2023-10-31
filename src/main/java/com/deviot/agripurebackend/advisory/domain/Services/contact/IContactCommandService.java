package com.deviot.agripurebackend.advisory.domain.Services.contact;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.CreateActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.CreateContactCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.DeleteContactCommand;

public interface IContactCommandService {
    String handle(CreateContactCommand createContactCommand);

    String handle(DeleteContactCommand deleteContactCommand);
}
