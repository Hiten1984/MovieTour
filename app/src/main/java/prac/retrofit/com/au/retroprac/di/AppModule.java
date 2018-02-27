package prac.retrofit.com.au.retroprac.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import prac.retrofit.com.au.retroprac.repository.MoviesRepository;
import prac.retrofit.com.au.retroprac.services.MessageService;
import prac.retrofit.com.au.retroprac.services.ServiceBuilder;

/**
 * Created by hbahri on 27/2/18.
 */

@Module
public class AppModule {

    MessageService messageService;

    @Singleton
    @Provides
    public MoviesRepository providesMoviesRepository(MessageService messageService) {
        return new MoviesRepository(messageService);
    }

    @Singleton
    @Provides
    public MessageService providesMessageService() {
        messageService = ServiceBuilder.buildService(MessageService.class);
        return messageService;
    }

}
