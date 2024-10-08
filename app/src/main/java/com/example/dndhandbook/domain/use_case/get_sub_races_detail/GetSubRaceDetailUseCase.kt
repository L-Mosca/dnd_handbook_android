package com.example.dndhandbook.domain.use_case.get_sub_races_detail

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.example.dndhandbook.domain.models.sub_race.toSubRaceDetail
import com.example.dndhandbook.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSubRaceDetailUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke(index: String): Flow<Resource<SubRaceDetail>> = flow {
        try {
            emit(Resource.Loading())
            val subRaceDetail = repository.fetchSubRaceDetail(index).toSubRaceDetail()
            emit(Resource.Success(data = subRaceDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }

}