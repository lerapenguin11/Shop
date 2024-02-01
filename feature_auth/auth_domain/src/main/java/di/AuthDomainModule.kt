package di

import com.example.auth_domain.repository.AuthRepository
import com.example.auth_domain.usecase.GetAddUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AuthDomainModule
{
    @Provides
    fun provideGetAddUserUseCase(repository : AuthRepository) : GetAddUserUseCase {
        return GetAddUserUseCase(repository)
    }
}