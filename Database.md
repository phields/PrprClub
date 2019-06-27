# Collections

## Collection：Users

| 字段名             | 字段类型 | 备注                               |
| ------------------ | -------- | ---------------------------------- |
| \_id               | objectId | $inc:1                             |
| userName           | string   | unique required                    |
| password           | string   | required                           |
| description        | string   |                                    |
| avatar             | string   |                                    |
| registerTime       | datetime |                                    |
| phone              | int      | $minimum&$maximum:11 required      |
| bilibili           | int      |                                    |
| role               | array    | $in:[*rolelist*]                   |
| active             | boolean  |                                    |
| illustrations      | array    | bsonType:object SubCollection:Work |
| live2ds            | array    | bsonType:object SubCollection:Work |
| models             | array    | bsonType:object SubCollection:Work |
| totalIllustrations | int      | $minimum:0                         |
| totalLive2ds       | int      | $minimum:0                         |
| totalModels        | int      | $minimum:0                         |

## Collection: Projects

| 字段名             | 字段类型 | 备注                  |
| ------------------ | -------- | --------------------- |
| \_id               | objectId | $inc:1                |
| manager            | object   | SubCollection:Author  |
| description        | string   |                       |
| startTime          | datetime |                       |
| projectName        | string   | required              |
| icon               | string   |                       |
| illustration       | object   | SubCollection:Work    |
| model              | object   | SubCollection:Work    |
| live2d             | object   | SubCollection:Work    |
| actor              | object   | SubCollection: Author |
| illustrationAuthor | object   | SubCollection:Author  |
| live2dAuthor       | object   | SubCollection:Author  |
| modelAuthor        | object   | SubCollection:Author  |
## Collection: Works

| 字段名       | 字段类型 | 备注                                 |
| ------------ | -------- | ------------------------------------ |
| \_id         | objectId | $inc:1                               |
| workName     | string   | unique required                      |
| type         | string   | $in["illustration","model","live2d"] |
| thumb        | string   |                                      |
| file         | string   |                                      |
| author       | object   | SubCollection:Author                 |
| description  | string   |                                      |
| downloadable | boolean  |                                      |

## Collection: Requests

| 字段名             | 字段类型 | 备注                                  |
| ------------------ | -------- | ------------------------------------- |
| \_id               | objectId | $inc:1                                |
| from               | object   | SubCollection:Author                  |
| to                 | object   | SubCollection:Project                 |
| needExtraResources | boolean  |                                       |
| status             | string   | $in:["processing"," success"," fail"] |

# SubCollections

## SubCollection: Author

| 字段名   | 字段类型 | 备注                                         |
| -------- | -------- | -------------------------------------------- |
| \_id     | objectId | referTo:uid                                  |
| userName | string   | unique required                              |
| avatar   | string   |                                              |
| role     | string   | $in:["actor", "mAuthor","lAuthor","iAuthor"] |

## SubCollection:Work

| 字段名   | 字段类型 | 备注                                  |
| -------- | -------- | ------------------------------------- |
| _id      | objectId | referTo:wid                           |
| workName | string   | unique required                       |
| type     | string   | $in:["illustration","model","live2d"] |
| thumb    | string   |                                       |

## SubCollection:Project

| 字段名      | 字段类型 | 备注                 |
| ----------- | -------- | -------------------- |
| _id         | objectId | referTo:pid          |
| projectName | string   | unique required      |
| manager     | object   | SubCollection:Author |
| icon        | string   |                      |

